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
	<h1>All Students</h1>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Age</th>
	      <th scope="col">Address</th>
	      <th scope="col">City</th>
	      <th scope="col">State</th>
	    </tr>
	  </thead>
	  <tbody>
<%-- 	  	<c:forEach items="${looks}" var="look">
 --%>		<tr> 
		   	<th scope="row">{Name}</th>
		    <td>{Age}</td>
		    <td>{Address}</td>
		    <td>{City}</td>
		    <td>{State}</td>
		 </tr>
<%-- 		</c:forEach>	
 --%>	  </tbody>
	</table>
	<%-- <form:form action="/looks/${look.id}/destroy" method="post" modelAttribute="look">
		      	<input type="hidden" name="_method" value="Create">
		      	<input type="submit" value="Create"/>
		      	</form:form> --%>
</body>
</html>