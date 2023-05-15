<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/04/2023
  Time: 9:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<table>
    <tr>
        <td colspan="4"></td>
        <td><button type="button"><a href="products?action=create">Add product</a></button></td>
    </tr>
    <tr>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Type</th>
        <th>Description</th>
        <th>Image</th>
        <th>Operation</th>
    </tr>
    <c:if test="${requestScope['create']!=null}">
        <tr>
            <td><input name="name" type="text"></td>
            <select name="brand">
                <c:forEach items="${requestScope['brandList']}" var="brand">
                    <option value="${brand.getId()}">${brand.getBrand()}</option>
                </c:forEach>
            </select>
            <td><input name="price" type="number" placeholder="vnd"></td>
            <select name="" id=""></select>
        </tr>
    </c:if>
    <c:forEach items="${requestScope['list']}" var="product">
        <tr>
            <td>${product.getName()}</td>
            <td>${product.getBrand()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getType()}</td>
            <td>${product.getDescription()}</td>
            <td><img src="${product.getImg()}" alt="product's image"></td>
            <td>
                <a href=""><button>Edit</button></a>
                <a href=""><button>Delete</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
