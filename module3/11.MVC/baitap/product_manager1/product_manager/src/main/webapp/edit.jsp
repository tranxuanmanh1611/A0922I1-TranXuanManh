<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/04/2023
  Time: 2:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resource/style.css">
</head>
<body>
<h1>Bạn đang chọn để sửa sản phẩm:</h1>
<c:if test="${requestScope['product']!=null}">
    <table>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Loại sản phẩm</th>
            <th>Thương hiệu</th>
            <th>Mô tả</th>
            <th>Hình ảnh</th>
        </tr>
        <tr>
            <td>${requestScope['product'].getName()}</td>
            <td>${requestScope['product'].getType()}</td>
            <td>${requestScope['product'].getBrand()}</td>
            <td>${requestScope['product'].getDescription()}</td>
            <td class="productImage"><img src="${requestScope['product'].getImg()}" alt=""></td>
        </tr>
    </table>
</c:if>
<h2>Nhập những thông tin mới hoặc <button><a href="products">Quay lại</a></button></h2>
<table>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Loại sản phẩm</th>
        <th>Thương hiệu</th>
        <th>Mô tả</th>
        <th>Hình ảnh</th>
    </tr>
    <form method="post" action="">
        <tr>
            <td><input type="text" placeholder="Nhập tên sp" name="name"></td>
            <td>
                <input type="text" name="type" list="type" placeholder="Nhập mới ở đây">
                <datalist id="type">
                    <c:forEach items="${requestScope['typeList']}" var="type">
                    <option value="${type.getType()}">
                        </c:forEach>
                </datalist>
            </td>
            <td>
                <input type="text" name="brand" list="brand" placeholder="Nhập mới ở đây">
                <datalist id="brand">
                    <c:forEach items="${requestScope['brandList']}" var="brand">
                    <option name="brand" value="${brand.getBrand()}">
                        </c:forEach>
                </datalist>
            </td>
            <td><input type="text" name="description"></td>
            <td><input type="text" name="img"></td>
            <td><button type="submit">Sửa</button></td>
        </tr>
    </form>
</table>
</body>
</html>
