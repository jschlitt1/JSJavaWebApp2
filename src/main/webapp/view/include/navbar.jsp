<%--
  Created by IntelliJ IDEA.
  User: charg
  Date: 2/4/2020
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%= request.getContextPath()%>/controller?page=index">Game Spot</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="<%= request.getContextPath()%>/controller?page=index" >Home</a></li>
            <li><a href="<%= request.getContextPath()%>/controller?page=list">List</a></li>
            <li><a href="<%= request.getContextPath()%>/controller?page=detail">Details</a></li>
            <li><a href="<%= request.getContextPath()%>/controller?page=login">Log In</a></li>
            <li><a href="<%= request.getContextPath()%>/controller?page=aeorgheogfbwned">Broken</a></li>
        </ul>
    </div>
</nav>

