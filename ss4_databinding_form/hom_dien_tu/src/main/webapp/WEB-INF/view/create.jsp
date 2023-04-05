<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hom Dien Tu</title>
</head>
<body>
    <form:form method="post" action="/homDienTu/create" modelAttribute="homDienTu">
        <table>
            <tr>
                <td><form:label path="languages">Languages: </form:label></td>
                <td><form:select path="languages" items="${languages}"/></td>
        </tr>
            <tr>
                <td><form:label path="pageSize">Page Size: </form:label></td>
                <td><form:select path="pageSize" items="${pageSize}"/></td>
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
                <input type="submit" value="Submit">
            </td>
        </tr>
        </table>
    </form:form>
</body>
</html>
