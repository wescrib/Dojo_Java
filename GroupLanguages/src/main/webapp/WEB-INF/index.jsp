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
		<title>Home</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>Group Language</h1>

		

		<table border=1>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		<c:forEach items="${languages}" var = "language">
			
			<tr>	
				<td><a href="/info/${language.id}">${language.name}</a></td>
				<td>${language.creator}</td>
				<td>${language.version}</td>
				<td><a href="/edit/${language.id}">Edit</a> <a href="/delete/${language.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</table><br>

		<form action="/kittykatlicklick"method="post">
		Language <input type="text" name="name"><br>
		Creator <input type="text" name="creator"><br>
		Version <input type="text" name="version"><br>
		<input type="submit" value="Submit">
		</form>



	</body>
</html>