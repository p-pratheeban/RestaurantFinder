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
<title>Restaurant</title>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation"><a href="../../">Home</a></li>
		<li role="presentation" ><a
			href="../../restaurant/findall">Restaurnt</a></li>
	</ul>
	<div class='row box'>
		<div class='col-lg-2'></div>
		<div class='col-lg-4'>
			<img src='data:image/jpg;base64,${restaurant.resImage}' width='300px'
				height='300px' />
		</div>
		<div class='col-lg-4'>
			<div>
				<h3>${restaurant.restaurantName}</h3>
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
		</div>
		<div class='col-lg-2'></div>
	</div>
	<div class='row box'>
		<div class='col-lg-2'></div>
		<div class='col-lg-8'>
		<table class="table table-striped">
			<tr>
				<th>Username</th>
				<th>Rating</th>
				<th>Feedback</th>				
				<th>Date</th>
			</tr>

			<c:forEach items="${reviews}" var="review">
				<tr>
					<td>${review.user.userName}</td>
					<td>${review.rating}</td>
					<td>${review.feedback}</td>					
					<td>${review.reviewDate}</td>
				</tr>
			</c:forEach>
		</table>			
		</div>
		<div class='col-lg-2'></div>
	</div>
	<div class="row" id="newfeedback">
		<div class="col-lg-2"></div>
		<form:form method="POST"
			action="../../restaurant/review/${restaurant.id}"
			commandName="review">

			<div class="form-group col-lg-8">
				<div>User</div>
				<div class="form-group col-lg-2">
					Rating
					<form:select path="rating" class="form-control">
						<form:option value="1" label="1" />
						<form:option value="2" label="2" />
						<form:option value="2" label="3" />
						<form:option value="2" label="4" />
						<form:option value="2" label="5" />
					</form:select>
				</div>
				<form:textarea id="feedback" class="form-control" cols="100"
					rows="4" path="feedback"></form:textarea>
			</div>
			<div class="col-lg-10 pull-right">
				<button type="submit" class="btn btn-primary" id="Post">Post</button>
			</div>
		</form:form>
	</div>
</body>
</html>