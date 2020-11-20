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

	<a href="/dashboard">Dashboard</a>
	<p>Title: ${look.title} </p>
	<p>Artist: ${look.artist}</p>
	<p>Rating(1-10): ${look.rating}</p>
	<a href="/books/${look.id}/edit">Edit Book</a>
<%-- 	<form action="/books/${look.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete"> --%>
</body>
</html>