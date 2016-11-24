<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 21.11.2016
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
h2 align="center">Please insert data</h2>
<form action="book.jsp" method="post">
    <h3>BookName</h3><input type="text" size="100" name="BookName">
    <h3>ISDN</h3><input type="text" size="100" name ="ISDN">
    <h3>Autor</h3><select name="autor" >
    <%-- генерируем список авторов--%>
    <% for (String autor : list) {%>
    <option value="<%=<%--serviceBook.selectAutorId(autor)--%>"><%=autor%></option>
    <%}%>
</select>
    <input type="submit" name="addBook" value="addBook">
</form>
</body>
</html>
