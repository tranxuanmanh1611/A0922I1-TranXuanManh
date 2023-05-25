<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2023
  Time: 9:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate Email</title>
</head>
<body>
<h3 style="color: red">${error}</h3>
<form action="validate" method="post" >
  <input type="text" name="email">
  <button type="submit">Create</button>
</form>
</body>
</html>
