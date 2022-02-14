<%--
  Created by IntelliJ IDEA.
  User: Tran Anh Tuan
  Date: 8/18/2018
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .result {
        color: red;
    }
</style>
<head>
    <title>$Title$</title>
</head>
<body>
<h1 class="result">Calculator</h1>
<form method="get" action="calculator">
    <td><input type="number" name="number1"></td>
    <td><input type="number" name="number2"></td>
    <p>
        <button type="submit" name="opera" value="+">Addition(+)</button>
        <button type="submit" name="opera" value="-">Subtraction(-)</button>
        <button type="submit" name="opera" value="*">Multiplication(*)</button>
        <button type="submit" name="opera" value="/">Division(/)</button>
    </p>
</form>
<h1 class="result">Result: ${result}</h1>
</body>
</html>