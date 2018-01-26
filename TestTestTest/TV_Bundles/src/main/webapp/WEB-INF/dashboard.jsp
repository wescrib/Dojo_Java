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
		<title>User Dashboard</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<a href="logout">Logout</a>
		<h1>Welcome to TVLands Cable Subscription Service ${current_user.firstName}</h1>
		<h3>Where the costs are made up and the bundles don't matter!</h3>
		<br><br><br><br>
		<form action="dashboard/subscribe" method="post">
			<p>Select a start date <input type="date" name="date" value="2018-01-26"></p>
		<select name="bundle">
			<c:forEach items="${bundles}" var="bundle">
				<c:choose>
					<c:when test="${bundle.available==true}">
						<option value="${bundle.id}">${bundle.name} - ${bundle.cost}0</option>
					</c:when>
				</c:choose>
			</c:forEach>
		</select>
		<input type="submit" value="Submit">
		</form>
	</body>
</html>