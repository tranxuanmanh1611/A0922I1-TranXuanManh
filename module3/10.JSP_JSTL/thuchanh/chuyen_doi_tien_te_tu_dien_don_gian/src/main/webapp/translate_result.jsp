<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/04/2023
  Time: 11:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>translate</title>
</head>
<body>
<%  String needSearchWord = request.getParameter("needSearchWord");
  String translatedWord =(String) request.getAttribute("translatedWord");%>
<h1>Translated</h1>
<h2>Searched: <%=needSearchWord%></h2>
<h2>Result: <%=translatedWord%></h2>

</body>
</html>
