<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 05.01.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
       value="<c:out value="${_csrf.token}"/>"/>

<form name="login" action="/login" method="GET">
    <table>
        <tr> <td>User:</td> <td><input type="text" name="username"></td></tr>

        <tr><td>Password:</td> <td><input type="password" name="password"></td></tr>

        <tr><td><button type="submit">Login</button></td></tr>

    </table>


</form>

</body>
</html>
