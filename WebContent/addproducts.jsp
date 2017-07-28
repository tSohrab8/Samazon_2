<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Products</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

	<div class="container">
		<h1>Add Product to Store</h1>
		<form action="AddProductServlet" method="post">
			Name : <input type="text" name="name"> <br/>
			Description : <input type="text" name="description"><br/>
			Count : <input type="text" name="count"> <br/>
			Price : <input type="text" name="price"><br/>
			Image URL : <input type="text" name="url"><br/>
			<input type="submit" value="Add Product">
		</form>
		<a class="pull-right" href="/Samazon_2">Return To Store</a>
	</div>

</body>
</html>