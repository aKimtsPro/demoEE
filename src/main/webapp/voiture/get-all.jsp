<!doctype html>

<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageService" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.service.GarageServiceImpl" %>
<%@ page import="be.bstorm.akimts.demoee.servlets.model.Voiture" %>

<%! private final GarageService service = GarageServiceImpl.getInstance(); %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>liste de voiture</title>
</head>
<body>

<div>
    <a href="${pageContext.request.contextPath}/voiture/add.jsp"><button>ajouter une voiture</button></a>
</div>


<ul>
    <% for (Voiture v : service.getAll()) { %>
    <li>[<%= v.getId() %>] <%= v.getMarque() %> - <%= v.getModele() %> - <%= v.getPrix() %> $ </li>
    <% } %>
</ul>


</body>
</html>