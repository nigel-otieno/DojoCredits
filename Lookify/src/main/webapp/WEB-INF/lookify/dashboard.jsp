<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Rating</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${students}" var="student">
		<tr> 
 		   	<th scope="row">${student.FirstName} ${student.LastName}</th>
 		    <td>${student.age}</td>
		    <td> ${student.contactInfo.address}</td>
		    <td> ${student.contactInfo.city}</td>
		    <td> ${student.contactInfo.state}</td>
		 </tr>
		</c:forEach>	
	  </tbody>
	</table>
</body>
</html>