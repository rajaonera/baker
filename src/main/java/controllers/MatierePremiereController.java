package main.java.controllers;

import main.java.connexion.Base;
import main.java.models.vente.*;
import main.java.models.stock.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import simpleController.CtrlAnnotation;
import simpleController.MereController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatierePremiereController", value = "*.matierePremiereController")
public class MatierePremiereController extends MereController {
    @CtrlAnnotation(name = "list")
    public void list() throws IOException, SQLException, ServletException {
        Connection connection = Base.PsqlConnect();
        MatierePremiere ex = new MatierePremiere();
        ex.getEagerLoads().add("unite");
        Unite[] unites = new Unite().getAll(connection);
        MatierePremiere[] matierepremieres = ex.getAll(connection);
        if (connection != null)
            connection.close();
        request.setAttribute("matierepremieres", matierepremieres);
        request.setAttribute("unites", unites);
        RequestDispatcher rd = request.getRequestDispatcher("/views/matierepremieres/list-matierepremieres.jsp");
        rd.forward(request, response);
    }

  @CtrlAnnotation(name = "create")
  public void create() throws Exception {
      String nom = request.getParameter("nom");
      String idUnite = request.getParameter("idUnite");
      int idUn = -1;

      if(idUnite == null) {
        response.sendRedirect("list.matierePremiereController?error=Unite manquante");
        return;
      }

      try {
        idUn = Integer.parseInt(idUnite);
      } catch(NumberFormatException e) {
        response.sendRedirect("list.matierePremiereController?error=Cet Unite n'existe pas");
        return;
      }

      if(nom == null) {
        response.sendRedirect("list.matierePremiereController?error=Nom manquante");
        return;
      }

      Connection connection = Base.PsqlConnect();

      try {
        if(new Unite().read("WHERE idUnite = " + idUnite, connection).size() <= 0) {
          response.sendRedirect("list.matierePremiereController?error=Cet unite n'existe pas");
          return;
        }
      } catch(Exception e) {
        response.sendRedirect("list.matierePremiereController?error=" + e.getClass() + " : " + e.getMessage());
        return;
      }

      MatierePremiere matierePremiere = new MatierePremiere();
      matierePremiere.setNom(nom);
      matierePremiere.setQuantite(0);
      matierePremiere.setUnite(idUn);

      try {
        matierePremiere.create(connection);
      } catch(Exception e) {
        response.sendRedirect("list.matierePremiereController?error=" + e.getClass() + " : " + e.getMessage());
        return;
      }

      if (connection != null)
        connection.close();

      response.sendRedirect("list.matierePremiereController");
  }

  @CtrlAnnotation(name = "delete")
  public void delete() throws Exception {
    int id;

    if (request.getParameter("idMatierePremiere") == null) {
      response.sendRedirect("list.matierePremiereController?error=Id de la matiere premiere manquante");
      return;
    }

    try {
      id = Integer.parseInt(request.getParameter("idMatierePremiere"));
    } catch (NumberFormatException e) {
      response.sendRedirect("list.matierePremiereController?error=L'id n'est pas un nombre");
      return;
    }

    Connection connection = Base.PsqlConnect();
    List<Object> matierepremieres = new MatierePremiere().read("WHERE idMatierePremiere = " + id, connection);

    if (matierepremieres.size() == 0) {
      response.sendRedirect("list.matierePremiereController?error=La matiere premiere n'existe pas");
      return;
    }

    MatierePremiere matierePremiere = (MatierePremiere) matierepremieres.get(0);
    try {
      matierePremiere.delete("", connection);
    } catch (Exception e) {
      response.sendRedirect(
              "list.matierePremiereController?error=" + e.getClass().getSimpleName() + " : " + e.getMessage());
      return;
    }
    response.sendRedirect("list.matierePremiereController");
  }
}
