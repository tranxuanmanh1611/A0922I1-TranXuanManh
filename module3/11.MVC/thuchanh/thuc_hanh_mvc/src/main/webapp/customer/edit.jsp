<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/04/2023
  Time: 9:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit form</title>
</head>
<body>

<h1>Bản ghi tìm được</h1>


<h1>Sua thông tin</h1>

<form method="post" action="">
  <table>
    <tr>
      <th>Tên</th>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <th>Email</th>
      <td><input name="email" type="text"></td>
    </tr>
    <tr>
      <th>Address</th>
      <td><input name="address" type="text"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Sua thong tin"></td>
    </tr>
  </table>
</form>

  <c:if test='${requestScope["message"]!= null}'>
    <h2>${requestScope['message']}</h2>
  </c:if>
<a href="customer">Trở về danh sách</a>
</body>
</html>
