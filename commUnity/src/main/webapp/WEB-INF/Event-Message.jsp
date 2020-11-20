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
	<h1><c:out value="${event.name}"></c:out></h1><br>
	
	<p>Host:<c:out value="${event.user.firstName}"></c:out></p>
	<p>Date: <c:out value="${event.date}"></c:out></p>
	<p>Location:<c:out value="${event.location}"></c:out></p>
	<p>People who are attending this event:<c:out value="${event.attendees.size()}"></c:out></p>
 	
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Location</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${event.attendees}" var="attendee">
		<tr> 
			<td> ${attendee.firstName}</td>
		    <td> ${attendee.location}</td>
		
		 </tr>
		</c:forEach>	
	  </tbody>
	</table>
</body>
</html>