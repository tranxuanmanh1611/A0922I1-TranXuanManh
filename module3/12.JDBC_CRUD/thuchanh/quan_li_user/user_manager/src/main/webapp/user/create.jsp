<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/04/2023
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<fieldset>
    <legend>Tạo mới người dùng</legend>
    <form method="post" action="users?action=create">
        <label for="">Nhập tên</label>
        <input type="text" name="name">
        <label for="">Nhập email</label>
        <input type="text" name="email">
        <label for="">Nhập quê</label>
        <input type="text" name="country">
        <button type="submit" >Tạo mới</button>
    </form>
</fieldset>
<c:if test="${requestScope['alert']!=null}">
    <h2>${requestScope['alert']}</h2>
</c:if>
<a href="users">Quay lại trang danh sách</a>
</body>
</html>
