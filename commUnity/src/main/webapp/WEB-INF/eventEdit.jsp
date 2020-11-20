<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>UPDATE Course</h1>
	<p><form:errors path="event.*"/></p>
		<form:form action="/events/${course.id}/update" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
		<form:hidden path="user"/>
		<form:hidden path="attendees"/>
	    <p>
	        <form:label path="name">Course Name:</form:label>
	        <form:textarea path="name"/>
	    </p>
	    <p>
	        <form:label path="date">Date:</form:label>
	        <form:input path="date" type="date"/>
	    </p>   
	    <p>
	        <form:label path="signups">Signups:</form:label>
	        <form:input path="signups"/>
	    </p>  
	    <input type="submit" value="Update"/>
	   </form:form>
</body>
</html>