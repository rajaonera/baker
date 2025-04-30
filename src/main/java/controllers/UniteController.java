package main.java.controllers;

import main.java.connexion.Base;
import main.java.models.vente.Unite;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import simpleController.CtrlAnnotation;
import simpleController.MereController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UniteController", value = "*.uniteController")
public class UniteController extends MereController {
    @CtrlAnnotation(name = "list")
    public void list() throws IOException, SQLException, ServletException {
        Connection connection = Base.PsqlConnect();
        Unite[] unites = new Unite().getAll(connection);
        if (connection != null)
            connection.close();
        request.setAttribute("unites", unites);
        RequestDispatcher rd = request.getRequestDispatcher("/views/unites/list-unites.jsp");
        rd.forward(request, response);
    }

    @CtrlAnnotation(name = "create")
    public void create() throws Exception {
        String nom = request.getParameter("nom");

        Unite unite = new Unite();
        unite.setNom(nom);

        Connection connection = Base.PsqlConnect();
        unite.create(connection);

        if (connection != null)
            connection.close();

        response.sendRedirect("list.uniteController");
    }

    @CtrlAnnotation(name = "delete")
    public void delete() throws Exception {
        int id;

        if (request.getParameter("idUnite") == null) {
            response.sendRedirect("list.uniteController?error=Id de l'unite manquante");
            return;
        }

        try {
            id = Integer.parseInt(request.getParameter("idUnite"));
        } catch (NumberFormatException e) {
            response.sendRedirect("list.uniteController?error=L'id n'est pas un nombre");
            return;
        } catch (Exception e) {
            response.sendRedirect(
                    "list.uniteController?error=" + e.getClass().getSimpleName() + " : " + e.getMessage());
            return;
        }

        Connection connection = Base.PsqlConnect();
        List<Object> unites = new Unite().read("WHERE idUnite = " + id, connection);

        if (unites.size() == 0) {
            response.sendRedirect("list.uniteController?error=Missing ");
            return;
        }

        Unite unite = (Unite) unites.get(0);
        try {
            unite.delete("", connection);
        } catch (Exception e) {
            response.sendRedirect(
                    "list.uniteController?error=" + e.getClass().getSimpleName() + " : " + e.getMessage());
            return;
        }
        response.sendRedirect("list.uniteController");
    }
}
