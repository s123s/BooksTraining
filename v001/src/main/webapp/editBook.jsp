<%@ page import="java.util.ArrayList" %>
<%@ page import="v001.ServiceBook" %>
<%@ page import="v001.Book" %><%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 19.11.2016
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%ServiceBook serviceBook = new ServiceBook();
    ArrayList<String> list = serviceBook.listAutor();
    ArrayList<Book> bookList = serviceBook.selectBook();
int idUpdate=-1;%>

<% if(request.getParameter("editBook")!=null){
    for(Book book : bookList){
        if(request.getParameter((Integer.toString(book.getIdBook())))!= null)
        {idUpdate = book.getIdBook();}
    }
serviceBook.updateBook(idUpdate, request.getParameter("editName"), request.getParameter("editISDN"),Integer.parseInt(request.getParameter("editAutor")));
}%>
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
