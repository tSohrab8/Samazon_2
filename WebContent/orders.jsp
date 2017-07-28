<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>

<body>

	<div class = "container">
		<h1>Previous Orders</h1>
		<table class="table table-bordered">
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Price Per Unit </th>
				<th>Total Price</th>
				<th>Order Number</th>
			</tr>
			<c:forEach var="cart" items="${orderHistory}">
				<tr>
					<td>${cart.product.productname}</td>
					<td>${cart.quantity}</td>
					<td>
						<fmt:formatNumber value = "${cart.product.price}" type = "currency"/>
					</td>
					<td>
						<fmt:formatNumber value = "${cart.quantity * cart.product.price}" type = "currency"/>
	         		</td>
	         		<td>
	         			${cart.userorder.orderid}
	         		</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/Samazon_2">Return Home</a>
	</div>
	

</body>
</html>