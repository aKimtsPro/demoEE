<!doctype html>

<!-- Les classes utilisées demande un import, on peut le faire comme suit -->
<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageService" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.model.Voiture" %>

<!-- Déclare une variable d'instance ou une méthode dans le Servlet résultant -->
<%! private final GarageService service = GarageServiceImpl.getInstance(); %>

<!-- chaque ligne écrit correspond à un  "out.println('la ligne') qu'on retrouverait dans un Servlet classique" -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

    <h1>Toutes les voitures</h1>

    <ul>
        <!-- On peut utiliser cette balise jsp pour sortir du comportement décrit à la ligne 11 -->
        <% for(Voiture v : service.getAll() ) { %>
        <!-- Pour intégrer des valeurs java au rendu final, on peut utiliser la balise <%= ... %> -->
        <li>[<%= v.getId() %>] - <%= v.getMarque() %> - <%= v.getModele() %> - <%= v.getPrix() %> $</li>
        <% } %>
    </ul>

</body>
</html>