<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount Calculator</title>
    <style>
        div {
            border: 1px solid black;
            padding: 10px 10px;
            display: flex;
            width: 200px;
            flex-wrap: wrap;
        }
        label{
            margin-bottom: 5px;
            margin-top: 5px;
        }
        button {
            position: relative;
            left: 132px;
            margin-top: 10px;
            width: fit-content;
        }

    </style>
</head>
<body>

<form method="post" action="discountCalculatorServlet">
    <div>
        <h1>Discount Calculator</h1>
        <label for="product_description">Product Description</label>
        <input type="text" id="product_description" name="description">
        <label for="price">Price</label>
        <input type="number" id="price" name="price">
        <label for="rate">Discount (%)</label>
        <input type="number" id="rate" name="rate">
        <button type="submit">Calculate</button>
        <a href="" target=""></a>
    </div>
</form>


</body>
</html>