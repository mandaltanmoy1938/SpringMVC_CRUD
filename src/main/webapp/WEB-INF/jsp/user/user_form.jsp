<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
<spring:url value="/save" var="saveURL" />
<form:form modelAttribute="userForm" method="POST" action="${saveURL}">
	<form:hidden path="id"/>
	<table>
	<tr>
		<th>First Name:</th>
		<td><form:input path="firstName"/></td>
	</tr>
	<tr>
		<th>Last Name:</th>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<th>Address:</th>
		<td><form:input path="address"/></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Save</button></td>
	</tr>
	</table>
</form:form>
</body>
</html>