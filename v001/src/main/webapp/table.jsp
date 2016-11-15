<%@page import="java.util.ArrayList"%>
<%@page import="v001.*"%>


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
		class="v001.MyQueryFactory" />
	asds


	<FORM TYPE=POST ACTION=checkresult.jsp>
		<BR>

		<%
			myQueryFactory.initConnection();
		%>
		<br> You have the following items in your cart:
		<ol>
			<%
				ArrayList<Book> books = myQueryFactory.returnBooksArrayList();
				for (Book book : books) {
			%>
			<li><input TYPE=checkbox name=fruit
				VALUE=<%out.print(book.name);%>> <%
 	out.print(book.name);
 %>
				<BR> <%
 	}
 %>
		</ol>
		<i> <INPUT TYPE=submit name=submit Value="Submit">
		</i>
		</FORM>
</body>
</html>