<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/05/2023
  Time: 8:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>borrowList</title>
    <link rel="stylesheet" href="style.css ">
</head>
<body>
<c:if test="${requestScope['alert']!=null}">
    <h2>${requestScope['alert']}</h2>
</c:if>
<table>
    <tr>
        <form method="post" action="servlet?action=search">
            <td><input type="text" name="studentName" placeholder="student name"></td>
            <td><input type="text" name="bookName" placeholder="or book name"></td>
            <td>
                <button type="submit">Search</button>
            </td>
        </form>
    </tr>
    <tr>
        <th><a href="servlet">
            <button>Tro lai booklist</button>
        </a></th>
    </tr>
    <tr>
        <th>ma muon sach</th>
        <th>ten sach</th>
        <th>tac gia</th>
        <th>ten hoc sinh</th>
        <th>lop</th>
        <th>ngay muon</th>
        <th>ngay tra</th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope['borrowList']}" var="borrow">

        <c:if test="${requestScope['error']!=null}">
            <tr>
                <td><h3>${requestScope['error']}</h3></td>
            </tr>
        </c:if>
        <tr>
            <td>${borrow.getId()}</td>
            <td>${borrow.getBook()}</td>
            <td>${borrow.getAuthor()}</td>
            <td>${borrow.getStudent()}</td>
            <td>${borrow.getClassroom()}</td>
            <td>${borrow.getBorrowDate()}</td>
            <td>${borrow.getBackDate()}</td>
            <td><a href="servlet?action=backbook&id=${borrow.getId()}&bookId=${borrow.getBookid()}" onclick="return cancelConfirm()">
                <button>tra sach</button>
            </a></td>
        </tr>
    </c:forEach>
</table>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">

    function editConfirm() {
        return window.confirm("Are you sure you want to edit this?")
    }

    function cancelConfirm() {
        return window.confirm("Are you sure you want to tra sach?")
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
