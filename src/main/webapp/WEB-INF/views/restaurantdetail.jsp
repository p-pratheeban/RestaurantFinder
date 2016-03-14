<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Details</title>
</head>
<body>
<div><a href="../welcome">Home</a></div>
	<div>
		<h1>${restaurant.restaurantName}</h1>
		<table>
			<tr>
				<td width="60%">Owner Name</td>
				<td>${restaurant.owner.getUserName()}</td>
			</tr>
			<tr>
				<td>Contact</td>
				<td>${restaurant.phoneNo}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${restaurant.state}</td>
			</tr>
			<tr>
				<td>city</td>
				<td>${restaurant.city}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${restaurant.description}</td>
			</tr>

		</table>
	</div>

	<br />
	<hr />
	<hr />
	<br />
	<div style="overflow: hidden;">
		<h2>List of Meals</h2>
		<table
			style="widht: 400px; border: 1px solid grey; border-radius: 5px;">
			<tr>
				<th width="-12%">Menu:</th>
				<th width="12%">Meals:</th>
				<th width="40%">Description</th>
				<th width="40%">Restaurant Id</th>
				<th width="40%" colspan="2">Action</th>

			</tr>

			<c:forEach items="${mealList}" var="meal">
				<tr>
					<td width="15%">${meal.menuType}</td>
					<td width="15%">${meal.mealName}</td>
					<td width="40%">${meal.description}</td>
					<td width="25%">${meal.restaurant.id}</td>
					<td width="25%"><a
						href="${pageContext.request.contextPath}/${meal.menuType}/${meal.restaurant.id}/edit/${meal.id}">Edit</a>
						/<a
						href="${pageContext.request.contextPath}/${meal.restaurant.id}/delete/${meal.id}">Delete
					</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<br />
	<hr />
	<hr />
	<br />

	<div style="overflow: hidden;">
		<h2>Click Menu to Add meal</h2>
		<table style="border: 1px solid grey;">

			<c:forEach items="${menuType}" var="meal">
				<tr>
					<td><a
						href="<c:url value='/meal/${meal}/restaurant/${restaurant.id}'/>">${meal}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>