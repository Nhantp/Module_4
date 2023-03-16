<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhân
  Date: 3/15/2023
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sach Hom Dien Tu</h1>
<table border="1">
    <tr>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach items="${homDienTu}" var="h">
    <tr>
        <td>${h.languages}</td>
        <td>${h.pageSize}</td>
        <td>${h.spamsFilter}</td>
        <td>${h.signature}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
