<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/04/2023
  Time: 11:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        div {
            border: 2px solid olive;
            display: flex;
            flex-wrap: wrap;
            width: 300px;
        }
    </style>
    <title>Vietnamese Dict</title>
</head>
<body>
<form method="post" action="translate">
    <div>
    <h1>Vietnamese Dictionary</h1>
    <input type="text"  name="needSearchWord">
    <button type="submit">Translate</button>
    </div>
</form>
</body>
</html>
