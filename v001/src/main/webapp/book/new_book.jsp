<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>edit book</h2>

	<FORM method="post" name="theForm" action="..\BookOperation" accept-charset="UTF-8">
		<input type="hidden" name="func" id="func"> 
		
		id<input type="input" name="id" readonly="readonly" value="" /> <BR>
		name<input type="input" name="name" value="" /> <BR>
		isdn<input type="input" name="isdn" value="" /> <BR>
		autor_id<input type="input" name="autor_id" value="" /> <BR>
			
			
			 <INPUT
			type="button" value="Сохранить"
			onclick="document.theForm.func.value='save_new_book'; document.theForm.submit();">

	</FORM>
</body>
</html>
