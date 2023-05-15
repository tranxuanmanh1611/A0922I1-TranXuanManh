<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/05/2023
  Time: 7:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Muon sach</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form method="post" action="">
    <table>
        <tr><th>Muon Sach</th></tr>
        <tr>
            <td>Ma muon sach:</td><td><input name="borrowId" type="text" placeholder="MS-XXXX" required></td>
        </tr>
        <tr>
            <td>Ten sach:</td><td>${requestScope['book'].getName()}</td>
        </tr>
        <tr>
            <td>Ten hoc sinh:</td>
            <td>
                <select name="studentId">
                    <c:forEach items="${requestScope['studentList']}" var="student">
                        <option value="${student.getId()}">${student.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ngay muon sach:</td>
            <c:if test="${requestScope['currentTime']!=null}">
                <td>${requestScope['currentTime']}</td>
            </c:if>
        </tr>
        <tr>
            <td>Ngay tra sach:</td><td><input name="backDate" type="date" required></td>
        </tr>
        <tr>
            <td><button type="submit">Muon sach</button></td>
            <td><a href="servlet">Huy</a></td>
        </tr>
    </table>
</form>

</body>
</html>
