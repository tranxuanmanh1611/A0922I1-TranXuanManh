<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/05/2023
  Time: 12:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>

<table>
<c:choose>
    <c:when test="${requestScope['error']!=null}"><h3>${requestScope['error']}</h3></c:when>
    <c:when test="${requestScope['alertBorrowSuccess']!=null}"><h3>${requestScope['alertBorrowSuccess']}</h3></c:when>
</c:choose>
    <tr><th>BookList</th><th><a href="servlet?action=borrowList"><button>Vao danh sach cho muon</button></a></th></tr>
    <tr>
        <th>Ma sach</th>
        <th>Ten sach</th>
        <th>Tac gia</th>
        <th>So luong</th>
        <th>Mo ta</th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope['bookList']}" var="book">
        <tr>
            <td>${book.getId()}</td>
            <td>${book.getName()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getAmount()}</td>
            <td>${book.getDescript()}</td>
            <td><a href="servlet?action=borrow&id=${book.getId()}&amount=${book.getAmount()}"><button>Muon</button></a></td>
        </tr>
    </c:forEach>
</table>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">

    function editConfirm() {
        return window.confirm("Are you sure you want to edit this?")
    }
    function cancelConfirm() {
        return window.confirm("Are you sure you want to cancel?")
    }
    function deleteConfirm() {
        return window.confirm("Are you sure you want to delete this?")
    }
    function createConfirm() {
        return window.confirm("Are you sure you want to create this?")
    }

</script>
</body>
</html>
