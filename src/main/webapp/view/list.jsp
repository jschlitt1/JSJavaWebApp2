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
        <th>Title</th>
        <th>Publisher</th>
        <th>Developer</th>
        <th>Popularity</th>
        <th>Editing</th>
    </tr>
    <c:forEach var="game" items="${games}">
        <tr>
            <td>${game.title}</td>
            <td>${game.publisher}</td>
            <td>${game.developer}</td>
            <td>${game.rating}</td>
            <td><form method="post"><input type="submit" value="Edit"></form></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="include/footer.jsp" %>