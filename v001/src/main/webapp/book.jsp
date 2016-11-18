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
<%
    ServiceBook serviceBook = new ServiceBook();
    ArrayList<Book> bookList = serviceBook.selectBook();%>
<html>
<head>
    <title>Book</title>
</head>
<form action="addBook.jsp">
<button>AddBook</button></form>
<form action=""><button>DeleteBook</button></form>

<h2 align="center">Books List</h2>
<table border="1" width="100%">
    <tr>
        <td align="center"><b>ChkBox</b></td>
        <td align="center"><b>ID</b></td>
        <td align="center"><b>Book Name</b></td>
        <td align="center"><b>ISDN</b></td>
        <td align="center"><b>AutorId</b></td>
    </tr>


    <% for (Book book :bookList) {%>
    <tr>
    <td align="center"><input type="checkbox" onclick="alert(12);"value="<%=book.getIdBook()%>"></td>
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
