<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/04/2023
  Time: 9:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
    <h1>User Management</h1>
    <a href="users?action=create">Add New User</a>
    <form method="post" action="users?action=countryFilter">
        <fieldset>
            <legend>Filter</legend>

            <select name="country">
                <c:forEach items="${requestScope['countries']}" var="country">
                <option value="${country}">${country}</option>
                </c:forEach>
            </select>

                <select name="order">
                    <option value="ASC">A-Z</option>
                    <option value="DESC">Z-A</option>
                </select>

            <input type="submit" value="Lọc">
            <button><a href="users">Xóa bộ lọc</a></button>
        </fieldset>
    </form>
    <h2>List of Users</h2>
    <table>
        <tr><th>Name</th><th>Email</th><th>Country</th></tr>
        <c:choose>
            <c:when test="${requestScope['listByCountry']!=null}">
                <c:forEach items="${requestScope['listByCountry']}" var="listByCountry">
                    <tr>
                        <td>${listByCountry.getName()}</td>
                        <td>${listByCountry.getEmail()}</td>
                        <td>${listByCountry.getCountry()}</td>
                        <td><a href="users?action=edit&id=${listByCountry.getId()}">Sửa</a></td>
                        <td><a href="users?action=delete&id=${listByCountry.getId()}">Xóa</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope['list']}" var="list">
                    <tr>
                        <td>${list.getName()}</td>
                        <td>${list.getEmail()}</td>
                        <td>${list.getCountry()}</td>
                        <td><a href="users?action=edit&id=${list.getId()}">Sửa</a></td>
                        <td><a href="users?action=delete&id=${list.getId()}">Xóa</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>
