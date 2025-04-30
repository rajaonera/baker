<%@ page language="java" contentType="text/html;charset=UTF-8" import="main.java.models.vente.Unite" %>
<%
    Unite[] unites = (Unite[]) request.getAttribute("unites");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Unités - Boulangerie</title>
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
        <h1>Liste des Unités de la Boulangerie</h1>
    </header>

    <div class="content">

        <form id="employeeForm" method="POST" action="create.uniteController">
            <h2>Ajouter une nouvelle unité</h2>
            <label for="nom">Nom de l'unité :</label>
            <input type="text" id="nom" name="nom" required>

            <button type="submit">Ajouter l'unité</button>
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
                <% if(unites != null) for(Unite unite : unites) { %>
                    <tr>
                        <td><%= unite.getId() %></td>
                        <td><%= unite.getNom() %></td>
                        <td><a href="delete.uniteController?idUnite=<%= unite.getId() %>">Supprimer</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
