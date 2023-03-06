<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhân
  Date: 3/6/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/dictionary">
    <h2>Dictionary</h2>
    <label>English</label>
    <input type="text" name="eng" placeholder="Enter English">
    <input type="submit" value="Submit">
    <h3>vietnamese: ${result}</h3>
</form>
</body>
</html>
