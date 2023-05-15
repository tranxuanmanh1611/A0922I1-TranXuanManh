<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/04/2023
  Time: 4:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin</title>
</head>
<body>
<h3>Bạn đang chọn để sửa người dùng: </h3>

<c:if test="${requestScope['user']!=null}">
    <p>Tên: ${requestScope['user'].getName()}</p>
    <p>Email: ${requestScope['user'].getEmail()}</p>
    <p>Country: ${requestScope['user'].getCountry()}</p>
</c:if>

<form method="post" action="">
    <fieldset>
        <legend>form sua thong tin</legend>
        <label for="">Tên</label>
        <input type="text" name="name">
        <label for="">Email</label>
        <input type="text" name="email">
        <label for="">Country</label>
        <input type="text" name="country">
        <input type="submit" value="Sửa thông tin">
    </fieldset>
</form>
<c:if test="${requestScope['alert']!=null}">
    <h2>${requestScope["alert"]}</h2>
</c:if>
<a href="users">Trở lại trang danh sách</a>
</body>
</html>
