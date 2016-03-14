<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit ${menuType}for Restaurant${restaurantId }</title>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath}/${restaurantId}/update/${meal.id}"
		method="post" modelAttribute="meal">


		<form:label path="menuType">Menu Type:</form:label>
		<form:input path="menuType" value="${meal.menuType}" />
		<br />
		<br />

		<form:label path="mealName">Meal Name:</form:label>
		<form:input path="mealName" value="${meal.mealName}" />
		<br />
		<br />
		<form:label path="price">Price:</form:label>
		<form:input path="price" value="${meal.price}" />
		<br />
		<br />

		<form:label path="description">Description:</form:label>
		<form:textarea path="description" value="${meal.description}" />
		<br />
		<br />
		<%-- <form:label path="restaurant">Restaurant Id:</form:label>
		<form:input path="restaurant" value="${restaurantId}" />
		<br />
		<br />  --%>
		<input type="submit" value="Update" />
		<input type="reset" value="Cancel" />
	</form:form>

</body>
</html>