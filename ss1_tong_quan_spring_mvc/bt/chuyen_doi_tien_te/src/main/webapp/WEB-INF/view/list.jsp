
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyen doi tien te</title>
</head>
<body>
<h3>Chuyen Doi Tien Te</h3>
<form action="/convert">
    <label>USD</label>
    <br><br>
    <input type="text" name="usd" placeholder="Enter USD" value="${usd}">
    <br><br>
    <input type="submit" value="Submit">
    <h3>Ket qua: ${result}</h3>
</form>

</body>
</html>
