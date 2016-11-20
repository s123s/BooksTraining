<%@ page import="v001.ServiceBook" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 17.11.2016
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ServiceBook serviceBook = new ServiceBook();

 if(request.getParameter("addAutor")!=null){
    serviceBook.addAutor(request.getParameter("Autor"));
}
%>
<%
ArrayList<String> list = serviceBook.listAutor();
%>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<h2 align="center">Please insert data</h2>
<form action="book.jsp" method="post">
<h3>BookName</h3><input type="text" size="100" name="BookName">
<h3>ISDN</h3><input type="text" size="100" name ="ISDN">
<h3>Autor</h3><select name="autor" >
    <% for (String autor : list) {%>
    <option value="<%=serviceBook.selectAutorId(autor)%>"><%=autor%></option>
    <%}%>
</select>
<input type="submit" name="addBook" value="addBook">
</form>


<form action="addBook.jsp" method="get">
<h2 align="center">Add Autor</h2>
<h3>Autor</h3><input type="text" size="100" name="Autor">
<input type="submit" name="addAutor" value="addAutor">
    <% if(request.getParameter("addAutor")!=null){
        serviceBook.addAutor(request.getParameter("Autor"));
    }
    %>
</form>
</body>
</html>
