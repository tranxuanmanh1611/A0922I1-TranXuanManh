<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Customer" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/04/2023
  Time: 12:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>

<h1>Customers</h1>
<div>
    <div class="createButton"><a href="/customer?action=create">Thêm mới</a></div>
    <table>
        <tr>
            <td>Email</td>
            <td>Name</td>
            <td>Address</td>
        </tr>
        <c:forEach items="${requestScope['customers']}" var="customer">
        <tr>
            <td><a href="/customer?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?action=edit&id=${customer.getId()}">Sửa</a></td>
            <td><a href="/customer?action=delete&id=${customer.getId()}">Xóa</a></td>
        </tr>
        </c:forEach>
</div>

</table>
</body>
</html>
