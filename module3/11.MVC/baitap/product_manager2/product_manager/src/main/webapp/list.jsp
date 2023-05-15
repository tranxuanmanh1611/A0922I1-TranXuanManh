<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/04/2023
  Time: 8:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resource/style.css">
</head>
<body>



<table>
    <tr>
        <td colspan="4" class="blank">
            <a href="products">
                <button>
                    <h1>Danh sách sản phẩm</h1>
                </button>
            </a>
        </td>
        <td class="blank">
            <a href="products?action=create"><button class="create">Add product</button></a>
        </td>
        <td class="blank">
            <form method="post" action="products?action=search">
                <input type="text" name="content">
                <select name="type">
                    <option value="name">name</option>
                    <option value="bcdrand">brand</option>
                    <option value="description">description</option>
                </select>
                <button type="submit">Search</button>
            </form>
        </td>
    </tr>
    <tr>
        <th>Name</th>
        <th>Brand</th>
        <th>Type</th>
        <th>Description</th>
        <th>Image</th>
        <th>Operation</th>
    </tr>

    <c:if test="${requestScope['create']!=null}">
        <form method="post" action="">
            <tr>
                <td class="edit"><input type="text" name="name" placeholder="name"></td>
                <td class="edit">
                    <select name="brand">
                        <c:forEach items="${requestScope['brandList']}" var="brand">
                            <option value="${brand.getId()}">
                                    ${brand.getBrand()}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td class="edit">
                    <select name="type">
                        <c:forEach items="${requestScope['typeList']}" var="type">
                            <option value="${type.getId()}">
                                    ${type.getType()}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td class="edit"><input type="text" name="description" placeholder="color, inch, memory"></td>
                <td class="edit"><input type="text" name="img" placeholder="the url of image"></td>
                <td><button type="submit" class="change">Create</button><button type="button" class="cancel"><a href="products">Cancel</a></button></td>
            </tr>
        </form>
    </c:if>


        <c:choose>
            <c:when test="${requestScope['edit']!=null}">
                <c:forEach items="${requestScope['list']}" var="product_inner">
                    <c:choose>
                        <c:when test="${product_inner.getId()==requestScope['edit']}">
                            <form method="post" action="">
                                <tr><td colspan="5">Update product:</td></tr>
                                <tr>
                                    <td class="edit"><input type="text" name="name" placeholder="old: ${product_inner.getName()}"></td>
                                    <td class="edit">
                                        <select name="brand">
                                            <c:forEach items="${requestScope['brandList']}" var="brand">
                                                <option value="${brand.getId()}">${brand.getBrand()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="edit">
                                        <select name="type">
                                        <c:forEach items="${requestScope['typeList']}" var="type">
                                            <option value="${type.getId()}">${type.getType()}</option>
                                        </c:forEach>
                                        </select>
                                    </td>
                                    <td class="edit"><input type="text" name="description" placeholder="color inch..."></td>
                                    <td class="edit"><input type="text" name="img" placeholder="img url"></td>
                                    <td>
                                    <button type="submit" onclick="return confirmEdit()" class="change">Change</button>
                                        <button class="cancel" type="button">
                                            <a href="products">Cancel</a></button>
                                    </td>
                                </tr>
                            </form>
                        </c:when>

                        <c:otherwise>
                            <tr>
                                <td>${product_inner.getName()}</td>
                                <td>${product_inner.getBrand()}</td>
                                <td>${product_inner.getType()}</td>
                                <td>${product_inner.getDescription()}</td>
                                <td><img src="${product_inner.getImg()}" alt="product image"></td>
                                <td><a href="products?action=edit&id=${product_inner.getId()}"><button type="button" class="edit">Edit</button></a><a href="products?action=delete&id=${product.getId()}" onclick="return confirmDelete()"><button class="delete">Delete</button></a></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope['list']}" var="product">
                <tr>
                    <td>${product.getName()}</td>
                    <td>${product.getBrand()}</td>
                    <td>${product.getType()}</td>
                    <td>${product.getDescription()}</td>
                    <td><img src="${product.getImg()}" alt="product image"></td>
                    <td><a href="products?action=edit&id=${product.getId()}"><button type="button" class="edit">Edit</button></a>
                        <a href="products?action=delete&id=${product.getId()}" onclick="return confirmDelete()"><button class="delete" type="button">Delete</button></a></td>
                </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
</table>
<script>
    function confirmDelete(){
       return window.confirm("Bạn chắc chắn muốn xóa không?")
    }
    function confirmEdit(){
       return window.confirm("Bạn chắc chắn muốn sửa không?")
    }
</script>
</body>

</html>
