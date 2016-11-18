<%@ page import="v001.ServiceBook" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 17.11.2016
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ServiceBook serviceBook = new ServiceBook();
    ArrayList<String> list = serviceBook.listAutor();%>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<h2 align="center">Please insert data</h2>
<h3>BookName</h3><input type="text" size="100">
<h3>ISDN</h3><input type="text" size="100">
<h3>Autor</h3><select>
    <% for (String autor : list) {%>
    <option><%=autor%></option>
    <%}%>
</select>
<button>addBook</button>

<h2 align="center">Add Autor</h2>
<h3>Autor</h3><input type="text" size="100">
<button>addAutor</button>
</body>
</html>
