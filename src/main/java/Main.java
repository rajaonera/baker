package main.java;
import java.sql.Connection;

import main.java.connexion.Base;
import main.java.models.stock.MatierePremiere;
import models.stock.MouvMatierePremiere;

public class Main {
  public static void main(String[] args) throws Exception {
    Connection connection = Base.PsqlConnect();
    MatierePremiere[] mat = new MatierePremiere().getAll(connection);
    for (MatierePremiere matierePremiere : mat) {
      System.out.println( matierePremiere.getId() + " - "+ matierePremiere.getNom());
    }

    MouvMatierePremiere[] mouv = new MouvMatierePremiere().getAll(connection);

    for (MouvMatierePremiere mouvMatierePremiere : mouv) {
      System.out.println(mouvMatierePremiere.getId() + " - " + mouvMatierePremiere.getMatierePremiere() + " - " + mouvMatierePremiere.getMatierePremiere(connection).getNom());
    }
  }
}
