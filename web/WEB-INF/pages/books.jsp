<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

privet!!!!<br/>

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
            <td>${book.autor_id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
