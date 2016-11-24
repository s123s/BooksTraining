<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 17.11.2016
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="v001.ServiceBook"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="v001.Book" %>
<%@ page import="java.util.*" import="java.io.*"%>

<%
    ServiceBook serviceBook = new ServiceBook();
    ArrayList<Book> bookList = serviceBook.selectBook();
    int idDelete= -1;
 if(request.getParameter("delete")!= null){
    for(Book book : bookList){
        if(request.getParameter((Integer.toString(book.getIdBook())))!= null)
        {idDelete = book.getIdBook();}
    }
    serviceBook.deleteBook(idDelete);
}
%>
<% if(request.getParameter("addBook")!=null){
    serviceBook.addBook(request.getParameter("BookName"), request.getParameter("ISDN"), Integer.parseInt(request.getParameter("autor")));
}
%>




<html>
<head>
    <title>Book</title>
</head>
<body>

<form action="addBook.jsp">
<button>AddBook</button></form>
<form action="editBook.jsp">
    <button>EditBook</button></form>
<form action="book.jsp" method="GET">

<input type="submit" name="delete" value="Delete_book"/>


<h2 align="center">Books List</h2>
<table border="1" width="100%">
    <tr>
        <td align="center"><b>ChkBox</b></td>
        <td align="center"><b>ID</b></td>
        <td align="center"><b>Book Name</b></td>
        <td align="center"><b>ISDN</b></td>
        <td align="center"><b>AutorId</b></td>
    </tr>

    <%  ArrayList<Book> bookList1 = serviceBook.selectBook();
        for (Book book : bookList1) {%>
    <tr>
    <td align="center"><input type="checkbox" name="<%=book.getIdBook()%>" value="<%=book.getIdBook()%>"></td>
    <td align="center"><%=book.getIdBook()%></td>
    <td align="center"><%=book.getBookName()%></td>
    <td align="center"><%=book.getIsdn()%></td>
    <td align="center"><%=serviceBook.selectAutor(book.getIdAutor())%></td>
    </tr>
   <% }%>

    </table>


</form>
</body>
</html>