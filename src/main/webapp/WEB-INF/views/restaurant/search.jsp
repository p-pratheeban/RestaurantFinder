<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
	<style type="text/css">
	.box{
		margin:15px;
		padding:10px;
	}
	</style>
<title>Search Restaurant</title>
</head>
<body>
	<ul class="nav nav-pills">
		<li role="presentation"><a href="../welcome">Home</a></li>
		<li role="presentation"><a href="../restaurant/findall">Restaurnt</a></li>
	</ul>
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-9">
			<h3>Search Restaurant Details</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-1">
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control" placeholder="Restaurant Name" id="byname" />
		</div>
		<div class="col-lg-1">
			<input type="submit" class="form-control" value="search" id="searchbyname"/>
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control" placeholder="State" id="bystate"/>
		</div>
		<div class="col-lg-1">
			<input type="submit" class="form-control" value="search" id="searchbystate"/>
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control" placeholder="City" id="bycity"/>
		</div>
		<div class="col-lg-1">
			<input type="submit" class="form-control" value="search" id="searchbycity"/>
		</div>
		<div class="col-lg-1">
		</div>
	</div>
	<div></div>
	<div id="result">
		
	</div>
	<script type="text/javascript"
		src='<c:url value="/resources/js/jquery-2.1.4.min.js"/>'></script>
		<script type="text/javascript">
	  		$(document).ready(function() {
			$('#searchbyname').click(function() {
				searchByName();
				$('#byname').val('');
			});
			$('#searchbystate').click(function() {
				searchByState();
				$('#bystate').val('');
			});
			$('#searchbycity').click(function() {
				searchByCity();
				$('#bycity').val('');
			});
		});
		function searchByName(){
			var name = $('#byname').val();
			$.getJSON('${pageContext.request.contextPath}/restaurant/searchbyname',{name:name}, function(result) {
				console.log(result);
				$("#result").empty();
				$.each(result, function(i, obj) {
					var ele= displayResult(obj.restaurantName,obj.state,obj.city,obj.phoneNo,obj.description,obj.resImage);
					$(ele).appendTo('#result');
				});
			});
		}
		function searchByState(){
			var state = $('#bystate').val();
			$.getJSON('${pageContext.request.contextPath}/restaurant/searchbystate',{state:state}, function(result) {
				console.log(result);
				$("#result").empty();
				$.each(result, function(i, obj) {
					var ele= displayResult(obj.restaurantName,obj.state,obj.city,obj.phoneNo,obj.description,obj.resImage);
					$(ele).appendTo('#result');
				});
			});
		}
		function searchByCity(){
			var city = $('#bycity').val();
			$.getJSON('${pageContext.request.contextPath}/restaurant/searchbycity',{city:city}, function(result) {
				console.log(result);
				$("#result").empty();
				$.each(result, function(i, obj) {
					var ele= displayResult(obj.restaurantName,obj.state,obj.city,obj.phoneNo,obj.description,obj.resImage);
					$(ele).appendTo('#result');
				});
			});
		}
		function displayResult(name,state,city,phoneNo,description,image){
	  		var html = "<div class='row box'><div class='col-lg-3'></div><div class='col-lg-3'><img src='data:image/jpg;base64,"+image+"' width='300px' height='300px' /></div>"+
	  		"<div class='col-lg-3 box'><div><strong>Name:"+name+"</div><div>State: "+state+
	  		"</div><div>City: "+city+"</div><div>Contact No: "+phoneNo+"</div><div>"+description+"</div></div><div class='col-lg-3'></div></div>";
	  		return html;
	  	}
		</script>
</body>
</html>