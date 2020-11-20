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
	<h1>Contact Info</h1>
	<form:form action="/dashboard" method="post" modelAttribute="look">
    <p>
        <form:label path="students">First Name</form:label>
        <form:errors path="students"/>
        <form:input path="students"/>
    </p>
    <p>
        <form:label path="address">Last Name</form:label>
        <form:errors path="address"/>
        <form:textarea path="address"/>
    </p>
    <p>
        <form:label path="city">City</form:label>
        <form:errors path="city"/>
        <form:input path="city"/>
    </p>   
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>  
    <input type="submit" value="Create"/>
</form:form>    
</body>
</html>