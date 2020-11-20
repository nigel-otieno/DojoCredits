<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<%-- <h1>Manza Dormitory</h1>
	<form:form action="/dorms/create" method="post" modelAttribute="dorm">
	 <p>
		<form:select path="student">
		<c:forEach items="${students}" var="student">
		
		<form:option value="${student.id}">
		<c:out value="${student.firstName}"/><c:out value="${student.lastName}"/>
		</form:option>
		
		</c:forEach>
		</form:select>
	</p>
    <table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${dorms}" var="dorm">
		<tr> 
		   	<th scope="row">${dorm.Name}</th>
		 </tr>
		</c:forEach>	
	  </tbody>
	</table> 
    </form:form>  --%>
    <h1><span class="text-danger"><c:out value="${dorm.name}"/></span></h1><br>

<form action="/dorms/${dorm.id}/add" method="post">
<label>Student :</label>
<select name="student">
<c:forEach items="${students}" var="student">
<option value="${student.id}">${student.firstName} ${student.lastName}</option>
</c:forEach>
</select>
<input class="btn btn-dark mb-2 mt-2" type="submit" value="Add">
</form>

<%-- form:form action="/dorms/${dorm.id}/add" method="POST" modelAttribute="dorm">
 <form:select path="students" class="form-control col-6 mb-2">
 			<c:forEach items="${students}" var="student">
 			
 			<form:option value="${student.id}">
 			<c:out value="${student.firstname}"/><c:out value="${student.lastname}"/>
 			</form:option>
 			
 			</c:forEach>
 			</form:select>
 			<input type="submit" class="btn btn-secondary" value="Add"/>
 		</form:form> --%>
 		
 		<br>
	<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${dorm.students}" var="student">
        <tr>
        	<th class="bg-primary"><c:out value="${student.firstName} ${student.lastName}"/></th>
            <td class="bg-success"><a href="/dorms/${student.id}/destroy/${dorm.id}"><span style="color:yellow"><i>Remove</i></span></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table><br>
</body>
</html>