<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/05/2023
  Time: 7:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
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
        <h1>Ung dung Dictionary English -> Vietnamese</h1>
        <a href="convertor">Chuyen den trang chuyen doi tien te</a>
    </div>
    <div class="form">
        <form method="get" action="translate">
            <input name="word" type="text">
            <button type="submit">Translate</button>
        </form>
    </div>
</div>
<c:if test="${requestScope['result']!=null}">
    <h2>Ket qua: ${result}</h2>
</c:if>
</body>
</html>
