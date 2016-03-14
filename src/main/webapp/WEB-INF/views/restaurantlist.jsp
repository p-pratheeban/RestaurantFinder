<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><a href="welcome">Home</a></div>
	<h2>list of restaurant !!!</h2>
	<table id="restaurantlist" border="1">
		<tr>
			<td>ID</td>
			<td>Restaurant Name</td>
			<td>Owner</td>
			<td>Contact</td>
			<td>City</td>
			<td>State</td>
		</tr>
		<c:forEach items="${restaurants}" var="restaurant">
			<tr>
				<td>${restaurant.id}</td>
				<td><a href="<c:url value='/view/${restaurant.id}'/>">${restaurant.restaurantName}</a></td>
				<%-- <td>${restaurant.restaurantName}</td> --%>
				<td>${restaurant.owner.getUserName()}</td>
				<td>${restaurant.phoneNo}</td>
				<td>${restaurant.city}</td>
				<td>${restaurant.state}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>