<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register For Samazon</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h1>Register For Samazon</h1>
		<p> Not a member? Fill out the fields below to register an account </p>
		
		<form action="RegisterServlet" method="post">
			
			Name <input type="text" name="name"> <br/>
			Email <input type="text" name="email"> <br/>
			Password <input type="password" name="password"> <br/>
			<input type="submit" value="Register">
		
		</form>
	</div>

</body>
</html>