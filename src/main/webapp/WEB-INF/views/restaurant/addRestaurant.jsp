<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<style>
.errorborder{
	color:#000000;
	background-color:#ffeeee;
	border:3px solid #ff0000;
	padding:8px;
	padding:16px;
}
.error{
	color:#ff0000
}
</style>
<title>Add New Restaurant</title>
</head>
<body>
<ul class="nav nav-pills">
		<li role="presentation" ><a
			href="../welcome">Home</a></li>
		<li role="presentation" ><a
			href="../restaurant/findall">Restaurant</a></li>
</ul>
<div>Language : <a href="?lang=en">English</a>|<a href="?lang=ta">Tamil</a></div>
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-9">
			<h3><spring:message code="label.add"/></h3>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-8">
			<form:form method="POST" action="../restaurant/create"
				commandName="restValues" enctype="multipart/form-data"
				class="form-horizontal">
				<form:errors path="*" cssClass="errorborder" element="div" />
				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.name"/></label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" id="name" path="restaurantName"
							placeholder="Restaurant Name" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="restaurantName" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label class="col-lg-2"><spring:message code="label.state"/></label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="state" placeholder="State"/>
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="state" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.city"/></label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="city" placeholder="City" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="city" cssClass="error" />
					</div>
				</div>

				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.contact"/></label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="phoneNo"
							placeholder="Phone No" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="phoneNo" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.description"/></label>
					<div class="form-group col-lg-4">
						<form:input class="form-control" path="description"
							placeholder="description" />
					</div>
					<div class="form-group col-lg-5">
						<form:errors path="Description" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.owner"/></label>
					<div class="form-group col-lg-4">
						<form:select path="owner.userName" class="form-control">
							<form:options items="${owners}" itemValue="userName"
								itemLabel="userName" />
						</form:select>
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"><spring:message code="label.upload"/></label>
					<div class="form-group col-lg-4">
						<input type="file" name="image"></input>
					</div>
				</div>
				<div class="row">
					<label for="name" class="col-lg-2"></label>
					<div class="form-group col-lg-4">
						<input type="submit" value="Save" class="btn btn-primary">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>