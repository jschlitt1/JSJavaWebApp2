<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 1/21/2020
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Page</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Publisher</th>
        <th>Developer</th>
        <th>Popularity</th>
        <th>Editing</th>
    </tr>
    <%--some sort of loop here through the database some random values for now--%>
    <tr>
        <td>COD: MW</td>
        <td>Activision</td>
        <td>Infinity Ward</td>
        <td>4</td>
        <td><form method="post"><input type="submit" value="Edit"></form></td>
    </tr>
</table>
</body>
</html>
