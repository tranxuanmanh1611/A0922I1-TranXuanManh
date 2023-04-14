<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/04/2023
  Time: 12:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<h1>Danh Sách Khách Hàng
</h1>
<table>
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${requestScope['customers']}" var="customer">
    <tr>
      <td>${customer.getName()}</td>
      <td>${customer.getBirth()}</td>
      <td>${customer.getAddress()}</td>
      <td><img src="${customer.getImg()}" alt=""> </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
