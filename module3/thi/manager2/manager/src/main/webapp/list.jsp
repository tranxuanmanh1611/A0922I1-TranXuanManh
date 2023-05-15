<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/05/2023
  Time: 6:50 CH
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
    <tr><th colspan="8">DANH SACH BENH AN</th></tr>
    <tr>
        <td>STT</td>
        <td>Ma benh an</td>
        <td>Ma benh nhan</td>
        <td>Ten benh nhan</td>
        <td>Ngay nhap vien</td>
        <td>Ngay ra vien</td>
        <td>Ly do nhap vien</td>
        <td>Tac vu</td>
    </tr>
    <c:forEach items="${requestScope['benh_an_list']}" var="item" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${item.getId()}</td>
            <td>${item.getBenhNhanId()}</td>
            <td>${item.getTenBenhNhan()}</td>
            <td>${item.getNgayVao()}</td>
            <td>${item.getNgayRa()}</td>
            <td>${item.getLiDo()}</td>
            <td>
                <a href="servlet?action=edit&id=${item.getId()}" ><button class="edit">Sua</button></a>
                <a href="servlet?action=delete&id=${item.getId()}" onclick="return deleteConfirm()"><button class="delete">Xoa</button></a>
            </td>
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
