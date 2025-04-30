<%@ page language="java" contentType="text/html;charset=UTF-8" import="main.java.models.stock.MatierePremiere" import="main.java.models.vente.*" %>
<%
    MatierePremiere[] matierepremieres = (MatierePremiere[]) request.getAttribute("matierepremieres");
    Unite[] unites = (Unite[]) request.getAttribute("unites");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Matieres Première - Boulangerie</title>
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
        <h1>Liste des Matieres Première de la Boulangerie</h1>
    </header>

    <div class="content">
        <form id="employeeForm" method="POST" action="create.matierePremiereController">
            <h2>Ajouter une nouvelle Matieres Première</h2>
            <label for="nom">Nom de la matiere première :</label>
            <input type="text" id="nom" name="nom" required>
            <select name="idUnite" id="idUnite" required>
                <option value="" selected disabled>-- Selectionnez une unité</option>
                <% for(Unite unite : unites) { %>
                    <option value="<%= unite.getId() %>"><%= unite.getNom() %></option>
                <% } %>
            </select>
            <button type="submit">Ajouter</button>
        </form>

        <table id="employeeTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Quantité</th>
                    <th>Unité</th>
                    <th>Supprimer</th>
                </tr>
            </thead>
            <tbody>
                <% if(matierepremieres != null) for(MatierePremiere matiere : matierepremieres) { %>
                    <tr>
                        <td><%= matiere.getId() %></td>
                        <td><%= matiere.getNom() %></td>
                        <td><%= matiere.getQuantite() %></td>
                        <td><%= matiere.getUnite(null).getNom() %></td>
                        <td><a href="delete.matierePremiereController?idMatierePremiere=<%= matiere.getId() %>">Supprimer</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
