<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
		<table class="table table-dark">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">Title</th>
			      <th scope="col">Description</th>
			      <th scope="col">Language</th>
			      <th scope="col">Number of Pages</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			   <c:forEach items="${books}" var="book">
			    <tr>
			      <th scope="row">${book.id}</th>
			      <td>${book.title}</td>
			      <td>${book.description}</td>
			      <td>${book.language}</td>
			      <td>${book.numberOfPages}</td>
			      <td>
			      	<a href="books/show/${book.id}">Show</a>
			      	<a href="books/${book.id}/edit">Edit</a>
			      	<form:form action="/books/${book.id}/destroy" method="post" modelAttribute="book">
			      	<input type="hidden" name="_method" value="delete">
			      	<input type="submit" value="Delete"/>
			      	</form:form>
			      </td>
			    </tr>
			    </c:forEach>	
		  </tbody>
		</table>
	<a href="/books/create">New Book</a>
</body>
</html>