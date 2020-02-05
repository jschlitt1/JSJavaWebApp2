<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 1/21/2020
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Detail Page</title>
    <%@ include file="include/bootstrap.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1>Game Name: <span id="gamename">COD: MW</span></h1>
<p>Description: <span id="description">first person shooter</span></p>
<p>Rating: <span id="rating">4</span></p>
<p>Size: <span id="size">100</span> <span id="sizetype">GB</span></p>

<p>Major Players</p>
<li>
    <%-- Would be a loop--%>
    <ul>Person 1</ul>
    <ul>Person 2</ul>
</li>
<p>Time Played: <span id="timeplayed">42 </span> hrs </p>
<%@ include file="include/footer.jsp" %>
