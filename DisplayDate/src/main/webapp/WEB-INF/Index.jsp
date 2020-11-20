<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Hello World</h1>
	<a href="/Date">Date Template</a>
	<a href="/Time">Time Template</a>
	<h2><c:out value="${dojoname}"/></h2>
</body>
</html>