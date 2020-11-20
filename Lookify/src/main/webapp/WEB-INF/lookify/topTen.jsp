<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h1>Top Ten Songs:</h1>
	<table class="table table-dark">
	  <tbody>
	  	<c:forEach items="${looks}" var="look">
		<tr> 
			<td>${look.rating}</td>
		   	<td>${look.title}</td>
		    <td>${look.artist}</td>
		 </tr>
		</c:forEach>	
	  </tbody>
	</table>
</body>
</html>