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
		<h1>Questions</h1>
		<a href="logout">Logout</a>
		
		<table>
			<thead>
				<tr>
					<th>Question:</th>
					<th>Tags:</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${questions}" var="question">
					<tr>
						<td><a href="/questions/ask/display/${question.id}">${question.question}</a></td>
						
						<td>
							<c:forEach items="${question.getTag()}" var="tag">
								${tag.subject},
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<a href="questions/ask">Post a Question!</a>
	</body>
</html>