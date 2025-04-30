package main.java.connexion;

import java.sql.*;

public class Base {
    private static final String database = "boulangerie";
    private static final String username = "postgres";
    private static final String password = " ";
    private static final int port = 5435;

    public static Connection PsqlConnect() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:" + port + "/" + database, username, password);
        } catch (Exception e) {
            System.out.println("Erreur de connexion");
            e.printStackTrace();
        }
        return c;
    }

    public static Date getDate() throws Exception {
        Date result = null;
        boolean isclosed = true;
        Connection cnx = Base.PsqlConnect();
        String sql = "SELECT NOW() as T";
        Statement stmt = cnx.createStatement();
        try (ResultSet res = stmt.executeQuery(sql);) {
            if (res.next()) {
                result = res.getDate("T");
            }
        }

        if (isclosed) {
            cnx.close();
        }
        return result;
    }
}
