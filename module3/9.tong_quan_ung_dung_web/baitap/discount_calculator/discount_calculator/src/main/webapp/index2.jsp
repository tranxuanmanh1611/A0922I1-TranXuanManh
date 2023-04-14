<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/04/2023
  Time: 8:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<div class="result">
  <h1>Result</h1>
  <%
    String description = request.getParameter("description");
    float price = Float.parseFloat(request.getParameter("price"));
    float rate =Float.parseFloat(request.getParameter("rate"));
    float total= (float)request.getAttribute("total");
  %>
  <h2>Product description: <%=description%></h2>
  <h2>Price: <%=price%></h2>
  <h2>Rate: <%=rate%></h2>
  <h2>Total need pay: <%=total%></h2>
</div>
</body>
</html>
