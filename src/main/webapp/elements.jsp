<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 2/4/2020
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Elements: <%= new java.util.Date()%></title>
</head>
<body>
<%! public String createTableData(int num){
    return "<td>" + num + "</td>";
}%>
<table>
    <%
        for(int row = 0;row < 5; row++){
            out.print("<tr>");
            for(int col = 0; col < 5; col++){
                out.print(createTableData(row * col));
            }
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
