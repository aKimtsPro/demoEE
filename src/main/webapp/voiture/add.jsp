<%--
  Created by IntelliJ IDEA.
  User: akimt
  Date: 08-12-22
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add voiture</title>
</head>
<body>

    <h1>Ajouter une voiture:</h1>

    <form action="${pageContext.request.contextPath}/voiture/add" method="post">
        <div>
            <label for="in-marque">marque: </label><br>
            <input type="text" id="in-marque">
        </div>
        <div>
            <label for="in-modele">modele: </label><br>
            <input type="text" id="in-modele">
        </div>
        <div>
            <label for="in-prix">prix: </label><br>
            <input type="number" id="in-prix">
        </div>

        <button type="submit">envoyer</button>
    </form>


</body>
</html>
