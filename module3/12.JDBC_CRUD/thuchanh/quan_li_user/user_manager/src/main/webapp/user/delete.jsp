<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/04/2023
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa</title>
</head>
<body>
<h3>Bạn đang muốn xóa người dùng:</h3>
<form method="post" action="">
    <c:if test="${requestScope['user']!=null}">
        <p>Tên: ${requestScope['user'].getName()}</p>
        <p>Email: ${requestScope['user'].getEmail()}</p>
        <p>Country: ${requestScope['user'].getCountry()}</p>
    </c:if>
    <h3>Cân nhắc kĩ, không thể hoàn tác</h3>
    <button><a href="users">Quay lại trang danh sách</a></button>
    <input type="submit" value="Xóa">
</form>
<c:if test="${requestScope['alert']!=null}">
    <h3>${requestScope['alert']}</h3>
</c:if>
</body>
</html>
