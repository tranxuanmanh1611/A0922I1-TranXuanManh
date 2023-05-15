<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/05/2023
  Time: 7:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Convertor</title>
    <style>
        body{
            box-sizing: border-box;
        }
        div.container{
            display: inline-block;
        }
        div.header{
            background-color: antiquewhite;
        }
        div.form{
            background-color: coral;

        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Ung dung chuyen doi USD -> VND</h1>
        <h3>Ti gia: 1usd=22000vnd</h3>
        <a href="dictionary">Chuyen den trang tu dien</a>
    </div>
    <div class="form">
        <form method="post" action="convert">
            <input name="usd" type="number">
            <button type="submit">Convert</button>
        </form>
    </div>
</div>
<c:if test="${requestScope['result']!=null}">
    <h2>Ket qua: ${result} VND</h2>
</c:if>
</body>
</html>
