
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dormitories</h1>
	<form:form action="/dorms/create" method="POST" modelAttribute="dorm">
	<form:errors path="name"/>
	<form:input path="name" class="form-control col-6 mb-2" placeholder="Name"/>
	<input type="submit" class="btn btn-primary"/>
	</form:form>
</body>
</html>