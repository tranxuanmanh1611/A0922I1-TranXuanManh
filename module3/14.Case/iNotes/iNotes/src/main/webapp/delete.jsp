<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/04/2023
  Time: 9:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Bạn đang chọn để xóa note:</h1>
<form method="post" action="">
  <div>
    <c:if test="${requestScope['note']!=null}">
      <div class="note">
        <h2>${requestScope['note'].getTitle()} <span style="background-color: green;color: white">${requestScope['note'].getType()}</span></h2>
        <p>${requestScope['note'].getContent()}</p>
      </div>
    </c:if>
    <button type="submit">Đồng ý</button>
    <button><a href="notes">Trở lại danh sách</a></button>
  </div>
</form>
  </body>
</html>
