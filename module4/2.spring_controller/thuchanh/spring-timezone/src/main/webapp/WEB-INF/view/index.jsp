<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/05/2023
  Time: 7:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The World Clock</title>
</head>
<body>
<h2>Current local times around the world</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form action="world-clock" method="get" id="locale">
    <select name="city"  onchange="document.getElementById('locale').submit()">
        <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
        <option value="Asia/Tokyo">Tokyo</option>
    </select>
</form>
</body>
</html>
