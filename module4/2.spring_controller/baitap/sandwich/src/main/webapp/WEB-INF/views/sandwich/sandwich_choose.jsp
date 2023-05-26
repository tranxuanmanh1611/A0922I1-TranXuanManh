<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/05/2023
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form:form modelAttribute="condiment" action="sandwich" method="post">
        <form:checkboxes path="condiments" items="${condimentList}"/>
        <button type="submit">submit</button>
    </form:form>
</body>
</html>
