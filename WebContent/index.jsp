<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" /><!-- fixes date not displaying correctly in Eclipse browser -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Samazon.com : Online Shopping</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<jsp:include page="Navigation.jsp"></jsp:include>

	    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
            	<img class="img-thumbnail" src="${gravatarURL}"/>
             <!--  <p class="lead">Quick Links</p> -->
                <div class="list-group">
                    <a href="/Samazon_2" class="list-group-item">Browse Products</a>
                    <a href="profile.jsp" class="list-group-item">My Profile</a>
                    <a href="CartServlet" class="list-group-item">My Shopping Cart</a>
                    <a href="OrderServlet" class="list-group-item">My Order History</a>
                    ${addProductOption}
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="images/banner1.png" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/banner2.png" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/banner3.png" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">
					
					<c:forEach var="product" items="${products}">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img style="height:180px;width:auto;margin-top:20px" src="${product.imageURL}" alt="">
                            <div class="caption">
                                <h5 class="pull-right">$${product.price}</h5>
                                <h5><a href="#">${product.productname}</a>
                                </h5>
                                <p>${product.description}</p>
                            </div>
                            
                            <form action="CartServlet" method="post">
                            	<div style="padding-left:20px;padding-right:20px;">
                            		<input class="pull-left input-sm" type="number" value="1" min="1" max="99" name="quantity">
                            		<input type="hidden" name="productid" value="${product.productid}">
                            		<input type="hidden" name="remove" value = "0">
                            		<input class="pull-right btn btn-sm btn-primary" type="submit" value="Add To Cart">
                            	</div>
                            </form>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                </div>
            </div>

			
        </div>

    </div>
	
</body>
</html>