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
		<a href="logout">Logout</a> <!-- THIS LOGOUT BUTTON ISNT WORKING FOR SOME REASON-->
		<h1>${question.question}</h1>
		<h2>Tags: <c:forEach items="${question.getTag()}" var="tag">
			${tag.subject},
		</c:forEach></h2>
		<br>
		<form:form action="${question.id}" method="post" modelAttribute="a"> <!-- MODEL ATTRIBUTE IS TALKING TO @MODEL ATTRIBUTE IN CONTROLLER -->
			<form:label path="answer">Answer
			<form:input path="answer"/>
			<form:errors path="answer"/>
			</form:label>
			<input type="submit" value="ANSWWWWER">
		</form:form>
		<!-- NO GETTERS BEING USED BELOW -->
		<c:forEach items="${answers}" var="answer">
			<h1>${answer.answer}</h1>
		</c:forEach>
		<h1></h1>
	</body>
</html>