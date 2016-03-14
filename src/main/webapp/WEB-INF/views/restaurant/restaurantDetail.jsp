<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<title>Update Restaurant</title>
</head>
<body>
	<ul class="nav nav-pills">
	<li role="presentation" ><a
			href="../../welcome">Home</a></li>
		<li role="presentation" ><a
			href="../../restaurant/findall">Restaurant</a></li>
	</ul>
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-9">
			<h3>Edit Restaurant Details</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-8">
				<form:form method="POST"  action="../../restaurant/edit/${restaurant.id}" commandName="restaurant" enctype="multipart/form-data">
				<form:errors path="*" cssClass="errorborder" element="div" />
				<div class="row">
					<label for="name" class="col-lg-2">Name :</label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" id="name" path="restaurantName"
							value="${restaurant.restaurantName}" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="restaurantName" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label class="col-lg-2">State :</label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="state" value="${restaurant.state}" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="state" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2">City :</label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="city" value="${restaurant.city}" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="city" cssClass="error" />
					</div>
				</div>

				<div class="row">
					<label for="name" class="col-lg-2">Contact No :</label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="phoneNo"
							value="${restaurant.phoneNo}" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="phoneNo" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2">Description :</label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="description"
							value="${restaurant.description}" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="description" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2">Owner :</label>
					<div class="form-group col-lg-4">
						<form:select path="owner.userName" class="form-control">
							
							<form:option value="${restaurant.owner.userName}" />
						</form:select>
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2">Upload Image</label>
					<div class="form-group col-lg-4">
						<input type="file" name="image"></input>
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"></label>
					<div class="form-group col-lg-4">
						<input type="submit" value="Update" class="btn btn-primary">
					</div>
				</div>
			</form:form>
		</div>
	</div>   

</body>
</html>