<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<title>Sign In</title>
</head>
<body>
	<h1>Spring Security - Sign In</h1>

	<div style="color: red">${message}</div>
	
	<form class="login-form" action="login" method="post">
	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<label for="username">User: </label>
		 	<input id="username" name="username" size="20" maxlength="50" type="text" />

			<label for="password">Password: </label>
			<input id="password" name="password" size="20" maxlength="50" type="password" />
			
			<input type="submit" value="Login" />
	</form>
</body>
</html>