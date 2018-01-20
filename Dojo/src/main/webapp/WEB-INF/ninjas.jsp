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
		<title>Adding Ninjas</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<a href="/dojo/">Add Dojos!</a> | <a href="/ninjas/addNinja">Add Ninjas! </a>
		<h1>New Ninja | ̿̿ ̿̿ ̿̿ ̿'̿'\̵͇̿̿\з= ( ▀ ͜͞ʖ▀) =ε/̵͇̿̿/'̿'̿ ̿ ̿̿ ̿̿ ̿̿ </h1>
		<form action="createNinja" method="post">
			<label>Dojo</label>
			<select name="dojo">
				<c:forEach items="${dojos}" var= "dojo">
				<option value="${dojo.id}">${dojo.location}</option>
				</c:forEach>
			</select>
			<label>First Name:</label>
			<input type="text" name="firstName">
			<label>Last Name:</label>
			<input type="text" name="lastName">
			<label>Age</label>
			<input type="text" name="age">
			<input type="submit" value="SHING!!!">
		</form>
	</body>
</html>