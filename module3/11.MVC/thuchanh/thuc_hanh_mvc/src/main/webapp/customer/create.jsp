<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/04/2023
  Time: 8:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Đã vào create.jsp</p>
<form method="post" action="/customer?action=create">
    <fieldset>
        <legend>Thông tin khách hàng</legend>

            <table>
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Tạo"></td>
                </tr>
            </table>
    </fieldset>
    <!-- Thông bao tao thanh cong -->
    <c:if test='${requestScope["message"]!= null}'>
        <h2>${requestScope['message']}</h2>
    </c:if>
    <a href="customer">Trở lại list khách hàng</a>
</form>
</body>
</html>
