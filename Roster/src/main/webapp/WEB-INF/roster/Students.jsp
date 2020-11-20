<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Students</h1>
	<form:form id="student" action="/create/new" method="post" modelAttribute="student">
    <p>
        <form:label path="firstName">First Name</form:label>
 		<form:errors path="firstName"/> 
        <form:input path="firstName" type="text"></form:input>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
       	<form:errors path="lastName"/>
        <form:input path="lastName" type="text"></form:input>
    </p>
    <p>
        <form:label path="age">Age</form:label>
   		<form:errors path="age"/>
      	<form:input path="age" type="text"></form:input>
    </p>   
    <input type="submit" value="Create"/>
	</form:form>  
</body>
</html>