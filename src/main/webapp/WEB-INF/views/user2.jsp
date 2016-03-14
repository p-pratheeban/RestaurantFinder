<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<div><a href="../welcome">Home</a></div>
<h1>
	Add a User
</h1>

<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<c:if test="${!empty user.userName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="userName">
				<spring:message text="Username"/>
			</form:label>
		</td>
		<td>
			<form:input path="userName" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:password path="password" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="phoneNo">
				<spring:message text="Phone Number"/>
			</form:label>
		</td>
		<td>
			<form:input path="phoneNo" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="roles">
				<spring:message text="User Role"/>
			</form:label>
		</td>
		<td>
		<form:select path="roles">
		    <option value="">Choose a Role</option>
		    <form:options items="${roles}"/>
		</form:select>
		</td> 
	</tr>
	
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.userName}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty user.userName}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Users List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">User Name</th>
		<th width="120">Email Address</th>
		<th width="120">Phone Number</th>
		<th width="120">Role</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.userName}</td>
			<td>${user.email}</td>
			<td>${user.phoneNo}</td>
			<td>${user.roles}</td>
			<td><a href="<c:url value='/user/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/user/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
