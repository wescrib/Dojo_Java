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
		<title>Admin Dashboard</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>Hello Administrator, ${current_user.firstName}</h1>
		<a href="logout">Logout</a>
		<a href="adminDash/create"><button>Create Account</button></a>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Account Type</th>
				<th>Edit/Delete</th>
			</tr>
			<tr>
				<c:forEach items="${users}" var="user">
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<c:choose>
						<c:when test="${user.admin == 'true'}">
							<td>Administrator</td>
						</c:when>
						<c:otherwise>
							<td>Standard</td>
						</c:otherwise>
					</c:choose>
					<td><a href="/edit/${user.id}">Edit</a> |<a href="/delete/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		<br><br><br>
		<h2>Bundle Numbers</h2>
		<table>
			<tr>
				<th>Bundle Name</th>
				<th>Bundle Cost</th>
				<th>Bundle Status</th>
				<th>Users</th>
				<th>Actions</th>
			</tr>
			<tr>
				<c:forEach items="${bundles}" var="bundle">
					<td>${bundle.name}</td>
					<td>${bundle.cost}0</td>
						<c:choose>
							<c:when test="${bundle.available == true}">
								<td>Available</td>
							</c:when>
							<c:otherwise>
								<td>Unavailable</td>
							</c:otherwise>
						</c:choose>
					<td>${bundle.getUsers().size()}</td>
						<c:choose>
							<c:when test="${bundle.available == true}">
								<c:choose>
										<c:when test="${bundle.getUsers().size()==0}">
											<td><a href="activity/${bundle.id}">Deactivate</a> | <a href="destroyB/${bundle.id}">Delete</a></td>
										</c:when>
										<c:otherwise>
											<td><a href="activity/${bundle.id}">Deactivate</a></td>
										</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${bundle.getUsers().size()==0}">
										<td><a href="activity/${bundle.id}">Activate</a> | <a href="destroyB/${bundle.id}">Delete</a></td>
									</c:when>
									<c:otherwise>
										<td><a href="activity/${bundle.id}">Activate</a></td>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
			</tr>
				</c:forEach>
		</table>
		<br><br><br>
		<h2>Bundle Creator</h2>
		<form:form action="/adminDash" method="post" modelAttribute="bundle">
			<p>
				<form:label path="name">Name of Bundle:
					<form:input path="name"></form:input>
					<form:errors path="name"></form:errors>
				</form:label>
			</p>
			<p>
				<form:label path="cost">Name of Bundle:
					<form:input path="cost"></form:input>
					<form:errors path="cost"></form:errors>
				</form:label>
			</p>
			<p>Activate upon creation?
				<input type="radio" name="availble" value="true">Yes
				<input type="radio" name="availble" value="false" checked>No
			</p>
			<input type="submit" value="Bundlize!">
		</form:form>




	</body>
</html>