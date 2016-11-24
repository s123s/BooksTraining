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
    <title>editBook</title>
</head>
<body>
<form action="editBook.jsp" method="post">
    <h3>BookName</h3><input type="text" size="100" name="editName">
    <h3>ISDN</h3><input type="text" size="100" name ="editISDN">
    <h3>Autor</h3><select name="editAutor" >
    <% for (String autor : list) {%>
    <option value="<%=serviceBook.selectAutorId(autor)%>"><%=autor%></option>
    <%}%>
</select>
    <input type="submit" name="editBook" value="editBook">
</form>
</body>
</html>
