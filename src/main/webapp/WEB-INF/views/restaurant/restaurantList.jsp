<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<style type="text/css">
.box {
	margin: 15px;
	padding: 10px;
	font-size: 15px;
}
</style>
<title>Restaurant Details</title>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation"><a href="../welcome">Home</a></li>
		<li role="presentation" class="active"><a href="../restaurant/findall">Restaurant</a></li>
		<li role="presentation"><a href="../restaurant/create">Add New</a></li>
		<li role="presentation"><a href="../restaurant/search">Search</a></li>
	</ul>
	<h1>Restaurant Details</h1>

	<c:forEach var="restaurant" items="${restaurants}">

		<div class='row box'>
			<div class='col-lg-2'></div>
			<div class='col-lg-4'>
				<img src='data:image/jpg;base64,${restaurant.resImage}'
					width='300px' height='300px' />
			</div>
			<div class='col-lg-4'>
				<div>
					<h3>
						<a href="../restaurant/view/${restaurant.id}">${restaurant.restaurantName}</a>
					</h3>
				</div>
				<table>
					<tr>
						<td>State:</td>
						<td>${restaurant.state}</td>
					</tr>
					<tr>
						<td>City:</td>
						<td>${restaurant.city}</td>
					</tr>
					<tr>
						<td>Contact No:</td>
						<td>${restaurant.phoneNo}</td>
					</tr>
					<tr>
						<td>Owner</td>
						<td>${restaurant.owner.userName}</td>
					</tr>

					<tr>
						<td colspan="2">${restaurant.description}</td>
					</tr>
				</table>
				<div>
					<ul class="nav nav-pills">
						<li role="presentation" class="active"><a
							href="../restaurant/edit/${restaurant.id}">edit</a></li>
						<li role="presentation" class="active"><a
							href="../restaurant/delete/${restaurant.id}">delete</a></li>
					</ul>
				</div>
			</div>
			<div class='col-lg-2'></div>
		</div>
	</c:forEach>

</body>
</html>