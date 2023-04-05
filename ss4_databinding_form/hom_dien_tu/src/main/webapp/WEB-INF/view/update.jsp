<%--
  Created by IntelliJ IDEA.
  User: Nhân
  Date: 3/15/2023
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hom Dien Tu</title>
</head>
<body>
<h1 ><b>Setting</b></h1>
<form:form method="post" action="/homDienTu/check" modelAttribute="homDienTu">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td><form:select selected="${languages}==${homDienTu.languages}" path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${pageSize}" selected="${pageSize}==${homDienTu.pageSize}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams filter:</form:label></td>
            <td><form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

