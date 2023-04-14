<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form method="post" action="converted">
    <div>
        <h1>Currency Converter USD to VND</h1>
        <label for="rate">Rate</label>
        <input type="number" name="rate" id="rate">
        <label for="usd">USD:</label>
        <input type="number" name="usd" id="usd">
        <button type="submit">Convert</button>
    </div>
    <a href="vietnamese_dictionary.jsp">Chuyen sang tu dien</a>
</form>
</body>
</html>