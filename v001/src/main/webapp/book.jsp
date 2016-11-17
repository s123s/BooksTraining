<%--
  Created by IntelliJ IDEA.
  User: yasha
  Date: 17.11.2016
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="v001.Book"%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<button>AddBook</button>
<button>Delete</button>
<h2 align="center">Books List</h2>
<table border="1" width="100%">
    <tr>
        <td align="center"><b >ChkBox</b></td>
        <td align="center"><b >ID</b></td>
        <td align="center"><b>Book Name</b></td>
        <td align="center"><b>ISDN</b></td>
        <td align="center"><b>AutorId</b></td>
    </tr>
    <%Book book = new Book();
      ResultSet rst = book.selectBook();%>

    <% while (rst.next()) {%>
    <tr>
    <td align="center"><input type="checkbox"></td>
    <td align="center"><%=rst.getInt("id")%></td>
    <td align="center"><%=rst.getString("name")%></td>
    <td align="center"><%=rst.getString("isdn")%></td>
    <td align="center"><%=rst.getInt("autor_id")%></td>
    </tr>
   <% }%>

    </table>
</body>
</html>
