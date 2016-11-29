<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 21.11.2016
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books</title>
</head>
<body>
Hello!!!
<%--%><c:if test="${!empty listBooks}">--%>

    <table border="1" width="100%">
    <tr>
    <td align="center"><b>ID</b></td>
    <td align="center"><b>Book Name</b></td>
    <td align="center"><b>ISDN</b></td>
    <td align="center"><b>AutorId</b></td>
    </tr>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.isdn}</td>
        </tr>
        </c:forEach>
        </table>
<%--</c:if>--%>
</body>

</html>
