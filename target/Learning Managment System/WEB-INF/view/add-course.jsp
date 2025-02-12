<!-- spring mvc form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Your New Course</h1>
 <!-- create a form  -->
 <form:form action="save-course" method="POST" modelAttribute="course">
  <label>Course Name</label>
  <form:input path="courseName"/>
 <br/>
  <label>Course Duration</label>
  <form:input path="courseDuration"/>
   <br/>
  <label>Instructor Name</label>
  
  <form:select path="instructor.id">
    
    <form:options items="${allInstructor}" itemLabel="name" itemValue="id" />

  </form:select>
  
   <input type="submit" value="Add course">
 </form:form>
 
 
</body>
</html>