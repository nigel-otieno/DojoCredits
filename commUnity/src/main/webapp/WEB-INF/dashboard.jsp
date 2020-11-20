<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/dashboard.css">
<script src="js/dashboard.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="#">commUnity</a>
	
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="#">Profile</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="#">Messages</a>
	    </li>
	 	<li class="nav-item">
	      <a class="nav-link" href="#">Events</a>
	    </li>
	    <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	        Settings
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="#">Edit Profile</a>
	        <a class="dropdown-item" href="#">Privacy & Security</a>
	        <a class="dropdown-item" href="#">Logout</a>
	      </div>
	    </li>
	  </ul>
	</nav>
	
	<div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="https://images.idgesg.net/images/article/2018/08/google_logo_black-100769125-large.jpg">
	    </div>
	    <div class="carousel-item">
	      <img src="chicago.jpg" alt="Chicago">
	    </div>
	    <div class="carousel-item">
	      <img src="ny.jpg" alt="New York">
	    </div>
	  </div>
	
	  <!-- Left and right controls -->
	<a class="carousel-control-prev" href="#demo" data-slide="prev">
	  <span class="carousel-control-prev-icon"></span>
	</a>
	<a class="carousel-control-next" href="#demo" data-slide="next">
	  <span class="carousel-control-next-icon"></span>
	</a>
	<%-- <h1>Welcome <c:out value="${user_logged.firstName}"/></h1>
	<a href="/logout">LogOut</a>
	<p>Here are some of the event in your state.</p>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">Host</th>
	  	  <th scope="col">Action/Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${eventsIn}" var="event">
		<tr> 
 		   	<th scope="row"><a href="/events/${event.id}">${event.name}</a></th>
 		    <td>${event.date}</td> 
		    <td> ${event.location}</td>
		    <td> ${event.user.firstName}</td> 
				<td>
					<c:choose>
		         
			         <c:when test = "${event.user.id == user_logged.id}">
			            <a href="/events/${event.id}/edit">Edit</a>
			            <a href="/events/${event.id}/delete">Delete</a>
			         </c:when>
			         
			         <c:otherwise>
			         
				         <c:choose>
				         <c:when test = "${event.attendees.contains(user_logged)}">
				            <span>joined<a href="/events/${event.id}/cancel">Cancel</a></span>
				         </c:when>
				         
				         <c:otherwise>
				           <a href="/events/${event.id}/join">Join</a>
				         </c:otherwise>
				        </c:choose>
				     </c:otherwise>
			      </c:choose>
		      </td> 
		 </tr>
		</c:forEach>
	  </tbody>
	</table>
	<a href="/books/${book.id}/edit">Edit Book</a>
	<p>Here are some of the event in other states.</p>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">State</th>
	      <th scope="col">Host</th>
	  	  <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${eventsOut}" var="event">
		<tr> 
 		   	<th scope="row"><a href="/events/${event.id}">${event.name}</a></th>
 		    <td>${event.date}"</td>
		    <td> ${event.location}</td>
		    <td> ${event.state}</td>
		    <td> ${event.user.firstName}</td>
		    <td>
		    <c:choose>
		         <fmt:formatDate pattern ="MMMM dd, yyyy" value= ""/>
			         <c:when test = "${event.user.id == user_logged.id}">
			            <a href="/events/${event.id}/edit">Edit</a>
			            <a href="/events/${event.id}/delete">Delete</a>
			         </c:when>
			         
			         <c:otherwise>
			         
				         <c:choose>
				         <c:when test = "${event.attendees.contains(user_logged)}">
				            <span>joined<a href="/events/${event.id}/cancel">Cancel</a></span>
				         </c:when>
				         
				         <c:otherwise>
				           <a href="/events/${event.id}/join">Join</a>
				         </c:otherwise>
				        </c:choose>
				     </c:otherwise>
			      </c:choose>
			  </td>
		 </tr>
		</c:forEach>	
	  </tbody>
	</table> --%>
	
	<%-- <h1>CREATE AN EVENT</h1>
	<form:form action="/events" method="post" modelAttribute="event">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:textarea path="name"/>
    </p>
    <p>
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:input path="date" type="date"/>
  
    </p>   
    <p>
        <form:label path="location">Location</form:label>
        <form:errors path="location"/>
        <form:input path="location"/>
        <form:select path="state">
		<c:forEach items="${states}" var="state">
			<form:option value="${state}">${state}</form:option>
		</c:forEach>
		</form:select>
    </p>  
    <input type="submit" value="Create"/>
    <p>
		<form:select path="student">
		<c:forEach items="${students}" var="student">
		
		<form:option value="${student.id}">
		<c:out value="${student.firstName}"/><c:out value="${student.lastName}"/>
		</form:option>
		
		</c:forEach>
		</form:select>
	</p>
    </form:form>    --%>
     
</body>
</html>