<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2023
  Time: 8:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate email-mvn</title>
</head>
<body>
<form action="validate" method="post">
    <input type="text" name="email">
    <button type="submit">Check</button>
</form>
<h3 style="color: red">${message}</h3>
</body>
</html>
