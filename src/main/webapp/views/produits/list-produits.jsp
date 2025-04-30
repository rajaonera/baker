<%@ page language="java" contentType="text/html;charset=UTF-8" import="main.java.models.vente.Produit" %>
<%
    Produit[] produits = (Produit[]) request.getAttribute("produits");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Produits - Boulangerie</title>
    <link rel="stylesheet" href="static/style.css">
</head>
<body>
    <% 
      String error = request.getParameter("error");
      if(error != null) { %>
        <div class="error" id="error">
          <div>
            <span onclick="document.getElementById('error').remove()"></span>
            <%= error %>
          </div>
        </div>
    <% } %>

    <header>
        <h1>Liste des Produits de la Boulangerie</h1>
    </header>

    <div class="content">

        <form id="employeeForm" method="POST" action="create.produitController">
            <h2>Ajouter une nouveau produit</h2>
            <label for="nom">Nom du produit :</label>
            <input type="text" id="nom" name="nom" required>

            <button type="submit">Ajouter un produit</button>
        </form>

        <table id="employeeTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Supprimer</th>
                </tr>
            </thead>
            <tbody>
                <% if(produits != null) for(Produit produit : produits) { %>
                    <tr>
                        <td><%= produit.getId() %></td>
                        <td><%= produit.getNom() %></td>
                        <td><a href="delete.produitController?idProduit=<%= produit.getId() %>">Supprimer</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
