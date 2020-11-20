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
	<form:form action="/contact/create" method="post" modelAttribute="contactInfo">
    <p>
		<form:select path="student">
		<c:forEach items="${students}" var="student">
		
		<form:option value="${student.id}">
		<c:out value="${student.firstName}"/><c:out value="${student.lastName}"/>
		</form:option>
		
		</c:forEach>
		</form:select>
	</p>
    <p>
        <form:label path="address">Address</form:label>
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