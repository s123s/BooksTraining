<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 11.12.2016
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autors</title>
</head>
<body>

privet!!!!<br/>

<table border="1" width="100%">
    <tr>
        <td align="center"><b>ID</b></td>
        <td align="center"><b>Autor Name</b></td>
        <td align="center"><b>Edit</b></td>
        <td align="center"><b>Delete</b></td>

    </tr>
    <c:forEach items="${listAutors}" var="autor">
    <tr>
        <td>${autor.id}</td>
        <td>${autor.name}</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>
