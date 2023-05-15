<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/04/2023
  Time: 7:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo ghi chú mới</title>
</head>
<body>
<form method="post" action="">
  <fieldset>
    <legend>Tạo ghi chú</legend>
    <label for="">Tiêu đề</label>
    <input type="text" name="title">
    <label for="">Nội dung</label>
    <input type="text" name="content">
    <select name="idType">
      <c:forEach items="${requestScope['typeList']}" var="type">
        <option value="${type.getId()}">${type.getType()}</option>
      </c:forEach>
    </select>
    <input type="submit" value="tạo ghi chú">
  </fieldset>
</form>
<c:if test="${requestScope['alert']!=null}">
  <h2>${requestScope['alert']}</h2>
  <button><a href="notes">Quay lại trang note nào</a></button>
</c:if>
</body>
</html>
