package main.java.controllers;

import main.java.connexion.Base;
import main.java.models.vente.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import simpleController.CtrlAnnotation;
import simpleController.MereController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProduitController", value = "*.produitController")
public class ProduitController extends MereController {
    @CtrlAnnotation(name = "list")
    public void list() throws IOException, SQLException, ServletException {
        Connection connection = Base.PsqlConnect();
        Produit[] produits = new Produit().getAll(connection);
        if (connection != null)
            connection.close();
        request.setAttribute("produits", produits);
        RequestDispatcher rd = request.getRequestDispatcher("/views/produits/list-produits.jsp");
        rd.forward(request, response);
    }

    @CtrlAnnotation(name = "create")
    public void create() throws Exception {
        String nom = request.getParameter("nom");

        Produit produit = new Produit();
        produit.setNom(nom);

        Connection connection = Base.PsqlConnect();
        produit.create(connection);

        if (connection != null)
            connection.close();

        response.sendRedirect("list.produitController");
    }

    @CtrlAnnotation(name = "delete")
    public void delete() throws Exception {
        int id;

        if (request.getParameter("idProduit") == null) {
            response.sendRedirect("list.produitController?error=Id du produit manquante");
            return;
        }

        try {
            id = Integer.parseInt(request.getParameter("idProduit"));
        } catch (NumberFormatException e) {
            response.sendRedirect("list.produitController?error=L'id n'est pas un nombre");
            return;
        } catch (Exception e) {
            response.sendRedirect(
                    "list.produitController?error=" + e.getClass().getSimpleName() + " : " + e.getMessage());
            return;
        }

        Connection connection = Base.PsqlConnect();
        List<Object> produits = new Produit().read("WHERE idProduit = " + id, connection);

        if (produits.size() == 0) {
            response.sendRedirect("list.produitController?error=Le produit n'existe pas");
            return;
        }

        Produit produit = (Produit) produits.get(0);
        try {
            produit.delete("", connection);
        } catch (Exception e) {
            response.sendRedirect(
                    "list.produitController?error=" + e.getClass().getSimpleName() + " : " + e.getMessage());
            return;
        }
        response.sendRedirect("list.produitController");
    }
}
