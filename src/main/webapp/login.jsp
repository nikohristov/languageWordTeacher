<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<input type="text" name="username"> 
			<br>
			<input type="text" name="password">
			<br>
			<input type="submit" value="Log in">
		</form>
	</div>
</body>
</html>