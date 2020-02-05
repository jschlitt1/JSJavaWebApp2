<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 1/21/2020
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Login Page</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>Login Page!</h1>
<form method="Post" action="">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username">
    <br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <br>
    <input type="submit" val="Log In">
</form>
<%@ include file="include/footer.jsp" %>
