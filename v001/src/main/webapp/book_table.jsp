<%@page import="java.util.ArrayList"%>
<%@page import="v001.model.Book"%>
<%@page import="v001.model.MyQueryFactory"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="myQueryFactory" scope="session"
		class="v001.model.MyQueryFactory" />

	<FORM method="post" name="theForm" action="BookOperation">
		<input type="hidden" name="func" id="func">

		<%
			myQueryFactory.initConnection();
		%>
		<br> Собственно, книги:
		<ol>
			<%
				ArrayList<Book> books = myQueryFactory.returnBooksArrayList();
				for (Book book : books) {
			%>
			<li><input type="checkbox" name="checked_id"
				VALUE=<%out.print(book.id);%>> <%
 	out.print(""+book.name+", "+book.isdn);
 %></li>
			<%
				}
			%>
		</ol>
		<BR>Операции с книгами <INPUT type="button" value="Удалить"
			onclick="document.theForm.func.value='delete_book'; document.theForm.submit();">
		<INPUT type="button" value="Новая"
			onclick="document.theForm.func.value='new_book'; document.theForm.submit();">
		<INPUT type="button" value="Редактировать"
			onclick="document.theForm.func.value='edit_book'; document.theForm.submit();"><br>

	</FORM>
</body>
</html>