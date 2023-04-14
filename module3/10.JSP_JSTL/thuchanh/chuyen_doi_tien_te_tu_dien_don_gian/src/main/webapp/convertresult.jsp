<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/04/2023
  Time: 9:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  float rate = Float.parseFloat(request.getParameter("rate"));
  float usd =Float.parseFloat(request.getParameter("usd"));
  float vnd = (float)request.getAttribute("vnd");

%>

        <h1>Result of money convert</h1>
        <h2>Rate: <%=rate%></h2>
        <h2>From: <%=usd%>$</h2>
        <h2>Will equal: <%=vnd%>VND</h2>




</body>
</html>
