<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - moneyExchange & dictionary</title>
    <style>
        input {
            display: block;
        }
    </style>
</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>
<br/>
<form method="post" action="converter">
    <input type="number" name="rate" value="22000" placeholder="rate">
    <input type="number" name="amount" value="0" placeholder="USD">
    <button type="submit" value="converter">Converter</button>
</form>
<br><h1>Từ điển Anh-viet đơn gian</h1>
<form method="post" action="translate">
    <input type="text" placeholder="Nhập vào đây" name="needTranslateWord">
    <button type="submit">Translate</button>
</form>
</body>
</html>