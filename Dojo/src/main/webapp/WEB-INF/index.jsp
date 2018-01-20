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
		<h1>New dojo (づ｡ ◕‿‿◕｡) づ</h1>
		<a href="/dojo/">Add Dojos!</a> | <a href="/ninjas/addNinja">Add Ninjas! </a>
		<br><br>
		<form action="addLocation" method="post">
		<label>Name:</label>
		<input type="text" name="location">
		<input type="submit" value="Create">
		</form>
		<c:forEach items="${dojos}" var="kitty">
				<p><a href="/dojo/dojoDisplay/${kitty.id}">${kitty.location}</a></p>
		</c:forEach>
	</body>
</html>