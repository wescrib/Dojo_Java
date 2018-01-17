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
		<form action='/submit' method="post">
			<p>Name: <input type='text' name='name'></p>
			<p>What is your favorite car company?
			<select name="make">
				<option value="blank"></option>
				<option value="ford">Ford</option>
				<option value="chevy">Chevy</option>
				<option value="mercedes">Mercedes</option>
				<option value="audi">Audi</option>
			  </select></p>
			  <p>Do you drive an automatic?
				  <select name = "transmission">
					  <option value="Yes">Yes</option>
					  <option value="No">No</option>
				  </select>
			  </p>
			  <input type='submit' value='submit'>
			<hr>
		</form>
	</body>
</html>