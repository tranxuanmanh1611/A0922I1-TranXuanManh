<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/05/2023
  Time: 6:52 CH
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
    <tr><th colspan="2">SUA THONG TIN BENH AN</th></tr>
    <form method="post" action="">
        <c:if test="${requestScope['benh_an']!=null}">
            <tr>
                <td>Ma benh an:</td>
                <td>${requestScope['benh_an'].getId()}</td></tr>
            <tr>
                <td>Ma benh nhan:</td>
                <td><input name="benh_nhan_id"  type="text" value="${requestScope['benh_an'].getBenhNhanId()}" disabled></td></tr>
            <tr>
                <td>Ten benh nhan</td>
                <td><input name="ten_benh_nhan" type="text" placeholder="Old: ${requestScope['benh_an'].getTenBenhNhan()}"></td></tr>
            <tr>
                <td>Ngay nhap vien:</td>
                <td><input name="ngay_vao" type="date" value="${requestScope['benh_an'].getNgayVao()}"></td>
            </tr>
            <tr>
                <td>Ngay ra vien:</td>
                <td><input name="ngay_ra" type="date" value="${requestScope['benh_an'].getNgayRa()}"></td>
            </tr>
            <tr>
                <td>Ly do nhap vien:</td>
                <td>
                    <input name="ly_do" type="text" placeholder="Old: ${requestScope['benh_an'].getLiDo()}">
                </td>
            </tr>
        </c:if>
        <tr>
            <button type="submit">Sua</button>
            <a href="servlet">Tro ve</a>
        </tr>
    </form>
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
