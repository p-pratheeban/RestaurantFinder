<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add ${menuType}for Restaurant${restaurantId }</title>
<style type="text/css">
.errorborder {
	color: #000000;
	background-color: #ffeeee;
	border: 3px solid #ff0000;
	padding: 8px;
	padding: 16px;
}

.error {
	color: #ff0000
}
</style>
</head>
<body>
<div><a href="../../../welcome">Home</a></div>
	<form:form
		action="${pageContext.request.contextPath}/restaurant/${restaurantId}/addMeal"
		method="post" modelAttribute="meal">
		<form:errors path="*" cssClass="errorborder" element="div" />
		<br />
		<form:label path="menuType">Menu Type:</form:label>
		<form:input path="menuType" value="${menuType }" />
		<br />
		<br />

		<form:label path="mealName">Meal Name:</form:label>
		<form:input path="mealName" />
		<form:errors path="mealName" cssClass="error" />
		<br />
		<br />
		<form:label path="price">Price:</form:label>
		<form:input path="price" />
		<form:errors path="price" cssClass="error" />
		<br />
		<br />

		<form:label path="description">Description:</form:label>
		<form:textarea path="description" />
		<form:errors path="description" cssClass="error" />
		<br />
		<br />
		<%-- <form:label path="restaurant">Restaurant Id:</form:label>
		<form:input path="restaurant" value="${restaurantId}" />
		<br />
		<br />  --%>
		<input type="submit" value="Save" />
		<input type="button" value="Cancel" />
	</form:form>

</body>
</html>