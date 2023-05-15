<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/04/2023
  Time: 8:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductList</title>
    <link rel="stylesheet" href="resource/style.css">
</head>
<body>


<table>
    <tr>
        <td colspan="5">
            <button class="create"><a href="products?action=create">Thêm sản phẩm</a></button>
            <button><a href="products?action=editOption">Sửa</a></button>
            <button><a href="products?action=deleteOption">Xóa</a></button>
        </td>
    </tr>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Loại sản phẩm</th>
        <th>Thương hiệu</th>
        <th>Mô tả</th>
        <th>Hình ảnh</th>
    </tr>
        <c:forEach items="${requestScope['productList']}" var="product">
            <tr>
                <td name="name">${product.getName()}</td>
                <td name="type">${product.getType()}</td>
                <td name="brand">${product.getBrand()}</td>
                <td name="description">${product.getDescription()}</td>
                <td name="img" class="productImage"><img src="${product.getImg()}" alt=""></td>
                <c:if test="${requestScope['editOption']!=null}">
                    <td>
                        <button><a href="products?action=edit&id=${product.getId()}">Sửa</a></button>
                    </td>
                </c:if>
                <c:if test="${requestScope['delete']!=null}">
                    <td>
                    <button><a href="products?action=confirm&id=${product.getId()}">Xóa</a></button>
                    </td>
                </c:if>
            </tr>
        </c:forEach>

    <!-- Xuất hiện khi có request tạo mới -->
    <c:if test="${requestScope['create']!=null}">
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
            </tr>
            <tr>
                <td colspan="3" class="blank"></td>
                <td>
                    <button class="cancel"><a href="products">Hủy</a></button>
                </td>
                <td>
                    <button type="submit">Tạo</button>
                </td>
            </tr>
        </form>
    </c:if>

</table>
</body>
</html>
