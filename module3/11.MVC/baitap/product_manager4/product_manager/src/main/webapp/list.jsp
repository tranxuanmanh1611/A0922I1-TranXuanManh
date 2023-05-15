<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/04/2023
  Time: 8:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductList</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <table>
        <tr>
            <td><a href="products"><button><h1>Product List</h1></button></a></td>
            <td><a href="products?action=create"><button class="create">Add Product</button></a></td>
        </tr>
        <tr>
            <th>Name</th>
            <th>Brand</th>
            <th>Type</th>
            <th>Price</th>
            <th>Description</th>
            <th>Image</th>
            <th>Operation</th>
        </tr>


        <c:if   test="${requestScope['create']!=null}">
            <form method="post" action="">
                <tr>
                    <th><input name="name" type="text"></th>
                    <th>
                        <select name="brand" >
                            <c:forEach items="${requestScope['brandList']}" var="brand">
                                <option value="${brand.getId()}">${brand.getBrand()}</option>
                            </c:forEach>
                        </select>
                    </th>
                    <th>
                        <select name="type" >
                            <c:forEach items="${requestScope['typeList']}" var="type">
                                <option value="${type.getId()}">${type.getType()}</option>
                            </c:forEach>
                        </select>
                    </th>
                    <th><input name="price" type="number"></th>
                    <th><input name="description" type="text"></th>
                    <th><input name="img" type="text"></th>
                    <th>
                        <button type="submit" class="create" onclick="return confirmCreate()">Create</button>
                        <a href="products"><button class="cancel" onclick="return confirmCancel()">Cancel</button></a>
                    </th>
                </tr>
            </form>
        </c:if>


                <c:forEach items="${requestScope['list']}" var="product">
                    <c:choose>
                        <c:when test="${product.getId()==requestScope['edit']}">

                            <tr>
                                <form method="post" action="">
                                <th><input name="name" type="text"></th>
                                <th>
                                    <select name="brand" >
                                        <c:forEach items="${requestScope['brandList']}" var="brand">
                                            <option value="${brand.getId()}">${brand.getBrand()}</option>
                                        </c:forEach>
                                    </select>
                                </th>
                                <th>
                                    <select name="type" >
                                        <c:forEach items="${requestScope['typeList']}" var="type">
                                            <option value="${type.getId()}">${type.getType()}</option>
                                        </c:forEach>
                                    </select>
                                </th>
                                <th><input name="price" type="number"></th>
                                <th><input name="description" type="text"></th>
                                <th><input name="img" type="text"></th>
                                <th>
                                    <button type="submit" class="edit" onclick="return confirmEdit()">Edit</button>
                                </form>
                                   <a href="products"><button class="cancel" onclick="return confirmCancel()">Cancel</button></a>
                                </th>


                            </tr>

                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>${product.getName()}</td>
                                <td>${product.getBrand()}</td>
                                <td>${product.getType()}</td>
                                <td>${product.getPrice()}</td>
                                <td>${product.getDescription()}</td>
                                <td><img src="${product.getImg()}" alt="Product's image"></td>
                                <td>
                                    <form method="post" action="products?action=showEdit&id=${product.getId()}">
                                        <button class="edit">Edit</button>
                                    </form>
                                    <form method="post" action="products?action=delete&id=${product.getId()}">
                                        <button onclick="return confirmDelete()" class="delete">Delete</button>
                                    </form>

                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

        
    </table>
<script>
    function confirmCreate(){
       return  window.confirm("You sure you want to add?");
    }
    function confirmCancel(){
        return  window.confirm("You sure you want exit?");
    }
    function confirmEdit(){
        return  window.confirm("You sure you want to edit?");
    }
    function confirmDelete(){
        return  window.confirm("You sure you want to delete?");
    }
</script>
</body>
</html>
