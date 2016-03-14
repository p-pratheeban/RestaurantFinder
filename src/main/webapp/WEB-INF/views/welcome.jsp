<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<title>Welcome</title>
</head>
<body>
	<div class="col-lg-12"><img width="100%" src="<c:url value="/resources/images/restaurant.jpg"/>"></div>
	<div>
	<ul class="nav nav-pills">
		<li role="presentation" ><a
			href="restaurant/findall">Restaurant</a></li>
		<li role="presentation" ><a
			href="list">Meal</a></li>
		<li role="presentation" ><a
			href="user/users">User</a></li>
		<li role="presentation" ><a
			href="login?logout">Logout</a></li>
	</ul>
	</div>
</body>
</html>