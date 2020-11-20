<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.email}" /></h1>
	<a href="/logout">Logout</a>
	<h1>CREATE A NEW COURSE</h1>
	<form:form action="/events" method="post" modelAttribute="event">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:textarea path="name"/>
    </p>
    <p>
        <form:label path="instructor">Instructor</form:label>
        <form:errors path="instructor"/>
        <form:input path="instructor"/>
  
    </p>   
    <p>
        <form:label path="capacity">Capacity:</form:label>
        <form:errors path="capacity"/>
        <form:input path="capacity"/>
    </p>  
    <input type="submit" value="Create"/>
    </form:form>
</body>
</html>