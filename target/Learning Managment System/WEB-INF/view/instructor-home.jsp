<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
  
  <%@include file="menu.jsp" %>

<div class="container">
  <h1>Avialable Instructors</h1>
  
   <form:form action="process-search" method="GET" modelAttribute="searchDTO">
 
    <label>Search Instructor : </label>
    <form:input path="id"/>  
    <input type="submit" value="search">
   </form:form>
   
   <br/>
  <div align="right">
   <a href="/selexp-lms/instructor-info">refresh list</a>
  </div> 
	<table class="table">
		<thead class="table-primary">
		  <tr>
		  <th>Instructor Id</th>
		  <th>Instructor Name</th>
		  <th>Instructor Teaching Exp</th>
		  <th>Instructor Email</th>
		  <th>courses</th>
		  </tr>
		</thead>

		<tbody>
			<c:forEach var="instructor" items="${instructorList}">
				<tr>
				    <td>${instructor.id}</td>
					<td>${instructor.name}</td>
					<td>${instructor.teachingExp}</td>
					<td>${instructor.emai}</td>
					<td>
					
					 <table class="table">
					   <thead class="table-warning">
					     <tr>
					       <td>name</td>
					       <td>duration</td>
					     </tr>
					   </thead>
					   
					   <tbody>
					   
					     <c:forEach var="course" items="${instructor.courses}">
					      <tr>
					        <td>${course.courseName}</td>
					        <td>${course.courseDuration}</td>
					        <td><a href="/selexp-lms/viewCourse?courseId=${course.id}">view</a></td>
					      </tr>
					     
					     </c:forEach>
					   
					   </tbody>
					 
					 </table>
					
					</td>
					
					<td><a href="/selexp-lms/deleteInsturctor?id=${instructor.id}" class="btn btn-danger">delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>