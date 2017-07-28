<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h1>Please login</h1>
		<form action="LoginServlet" method="post">
			Email: <input type="text" name="email" value="larry12345@gmail.com"><br/>
			Password: <input type="password" name="password" value="password"><br/>
			<input type="hidden" name="action" value="login">
			<input type="submit" value="Log In">
		</form>
		<p/>
		<a href="register.jsp">Don't have an account? Click here to sign up! It's free!</a>
		<p>${message}</p>
	</div>
</body>
</html>