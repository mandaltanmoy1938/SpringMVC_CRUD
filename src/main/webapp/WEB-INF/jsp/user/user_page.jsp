<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
<h1>User List</h1>
<table width="100%" border="1">
	<thead>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th colspan="2">Action</th>
		</tr>
	</thead>
	<tbody>
		<c:foreach items="${listUser }" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.address}</td>
				<td>
					<spring:url value="/update/${user.id}" var="updateURL"></spring:url>
					<a href="${updateURL}">Update</a>
				</td>
				<td>
					<spring:url value="/delete/${user.id}" var="deleteURL"></spring:url>
					<a href="${deleteURL}">Delete</a>
				</td>
			</tr>
		</c:foreach>
	</tbody>
</table>
</body>
</html>