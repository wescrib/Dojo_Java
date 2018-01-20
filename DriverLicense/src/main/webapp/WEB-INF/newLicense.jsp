<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>Create License</h1>
		<form action="createLicense" method="post">
			<p>Person: 
			<select name="human">
				<c:forEach items="${people}" var ="person">
				<!-- <input type="hidden" name="human" value="${person.id}"> -->
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
				</c:forEach>
			</select></p>

			<p>State: 
			<select name="state">
				<option>Alabama</option>
			</select></p>
			<br>
			<br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>