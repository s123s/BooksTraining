<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 07.01.2017
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h5>Войти в систему</h5>
<c:if test="${not empty param.login_error}">
  <span style="color: red; ">
    Your login attempt was not successful, try again.<br/><br/>
    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
  </span>
</c:if>

<form name="frm" action="<c:url value='login'/>" method="get">
    <table>
        <tr> <td>User:</td> <td><input type="text" name="username"></td></tr>

        <tr><td>Password:</td> <td><input type="password" name="password"></td></tr>

        <tr><td colspan="2"><input name="submit" type="submit"></td></tr>
        <tr><td colspan="2"><input name="reset" type="reset"></td></tr>
    </table>

    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
           value="<c:out value="${_csrf.token}"/>"/>
</form>

</body>
</html>
