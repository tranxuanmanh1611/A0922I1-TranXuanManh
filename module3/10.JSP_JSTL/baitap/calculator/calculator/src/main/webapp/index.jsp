<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>calculator</title>
</head>
<body>

<h1>Simple calculator</h1>
<form method="post" action="calculate">
    <fieldset>
        <legend>Calculator</legend>
        <label for="firstOperand">First Operand</label><input type="number" name="firstOperand" id="firstOperand">
        <select name="math" id="math">
            <option value="addition">+</option>
            <option value="subtraction">-</option>
            <option value="multiplition">multiple</option>
            <option value="division">devide</option>
            <option value="modulo">modulo</option>
        </select>
        <label for="secondOperand">Second Operand</label><input type="number" name="secondOperand" id="secondOperand">
        <input type="submit" value="calculate">
    </fieldset>
</form>

<div class="result">
   <c:if test="${requestScope['result']!=null}">
       <h2>Kết quả: ${requestScope['result']}</h2>
   </c:if>
</div>

</body>
</html>