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
	<form:form action="/search" method="post">
		      	<input type="text" name="artist" placeholder="Search">
		      	<input type="submit" value="Search"/>
	</form:form>
<%-- 	<h1>Songs By: ${look.artist}</h1>
 --%>	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Rating</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${artistSong}" var="look">
		<tr> 
			
		   	<th scope="row">${look.title}</th>
		    <td><a href="/songs/${look.id}">${look.artist}</a></td>
		    <td> ${look.rating}</td>
	
		 </tr>
		</c:forEach>	
	  </tbody>
	</table></body>
</html>