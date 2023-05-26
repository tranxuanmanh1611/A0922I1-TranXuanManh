<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/05/2023
  Time: 9:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        .operation {
            font-size: 20px;
            font-weight: bolder;
        }
        button {
            display: inline-block;
            width: 80px;
        }
    </style>
</head>
<body>
<h3>${result}</h3>
<form:form modelAttribute="calculator" action="calculator" method="post" id="calculator">
    <table>
        <tr><th>First Operand</th><th>Second Operand</th></tr>
        <tr>
            <td><form:input path="firstOperand"/></td>
            <td><form:input path="secondOperand"/></td>
        </tr>
        <tr>
            <td><form:button class="operation" name="operation" value="plus">+</form:button></td>
            <td><button class="operation" name="operation" value="minus">-</button></td>
        </tr>
        <tr>
            <td><button class="operation" name="operation" value="multiple">*</button></td>
            <td><button class="operation" name="operation" value="divide">/</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
