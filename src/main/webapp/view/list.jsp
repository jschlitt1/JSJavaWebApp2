<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 1/21/2020
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>List Page</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<form method="post"><input type="submit" value="Add"></form>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Publisher</th>
        <th>Developer</th>
        <th>Popularity</th>
        <th>Editing</th>
    </tr>
    <c:forEach var="game" items="${games}">
        <tr>
            <td>${game.Title}</td>
            <td>${game.Pubisher}</td>
            <td>${game.Devloper}</td>
            <td>${game.Rating}</td>
            <td><form method="post"><input type="submit" value="Edit"></form></td>
        </tr>
        <!--
        <p>{game.id}</p>
        <p>{game.title}</p>
        <p>{game.devloper}</p>
        <p>{game.pubisher}</p> -->
    </c:forEach>
    <%--some sort of loop here through the database some random values for now--
    <tr>
        <td>COD: MW</td>
        <td>Activision</td>
        <td>Infinity Ward</td>
        <td>4</td>
        <td><form method="post"><input type="submit" value="Edit"></form></td>
    </tr>
    <%--end loop--%>
</table>
<%@ include file="include/footer.jsp" %>