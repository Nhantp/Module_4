
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<h1>Calculation</h1>
<form action="calculate" method="post">
    <input type="text" name="text1" placeholder="number 1">
    <input type="text" name="text2" placeholder="number 2">
    <br><br>
    <input type="submit" name="operation" value="Add">
    <input type="submit" name="operation" value="Sub">
    <input type="submit" name="operation" value="Multi">
    <input type="submit" name="operation" value="Div">

    <input type="submit" value="Submit">
    <br><br>
    <label>Ket Qua: ${result}</label>
</form>
</body>
</html>
