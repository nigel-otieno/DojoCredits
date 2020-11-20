<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CREATE A SHOW</h1>
	<p><c:out value="${error}" /></p>
	<form:form action="/show/create" method="post" modelAttribute="event">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:textarea path="name"/>
    </p>
    <p>
        <form:label path="location">location</form:label>
        <form:errors path="location"/>
        <form:input path="location"/>
  
    </p>   
    <p>
        <form:label path="country">Country</form:label>
        <form:errors path="country"/>
        <form:select path="country">
		<c:forEach items="${country}" var="country">
			<form:option value="${country}">${country}</form:option>
		</c:forEach>
		</form:select>
    </p>  
    <input type="submit" value="Create"/>
    </form:form>   
</body>
</html>