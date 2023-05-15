<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/04/2023
  Time: 3:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope['id']!=null  }">
    <h1>Bạn có chắc chắn muốn xóa:</h1>
    <form method="post" action="products?action=delete&id=${requestScope['id']}">
        <p><button type="submit">Xóa</button></p>
        <p><button><a href="products">Hủy</a></button></p>
    </form>
</c:if>



</body>
</html>
