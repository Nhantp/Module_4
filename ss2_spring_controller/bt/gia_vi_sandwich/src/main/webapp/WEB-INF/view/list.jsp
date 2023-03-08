<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhân
  Date: 3/8/2023
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiment" method="post">
  <label>Lettuce</label>
  <input type="checkbox" name="condiment" value="Lettuce">
  <label>Tomato</label>
  <input type="checkbox" name="condiment" value="Tomato">
  <label>Mustard</label> q
  <input type="checkbox" name="condiment" value="Mustard">
  <label>Sprouts</label>
  <input type="checkbox" name="condiment" value="Sprouts">
  <br><br>
  <input type="submit" value="Submit">
  <c:forEach items="${result}" var="r">
    <h3>${r}</h3>
  </c:forEach>
</form>
</body>
</html>
