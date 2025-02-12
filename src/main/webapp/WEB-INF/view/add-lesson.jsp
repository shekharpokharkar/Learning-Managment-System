<!-- spring mvc form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
<div class="container">
<h1>Create Your New Lesson</h1>
 <!-- create a form  -->
 <form:form action="save-lesson" method="POST" modelAttribute="lesson">
  <form:hidden path="course.id"/>
  <form:hidden path="lessonId"/>
  <label>Lesson Name</label>
  <form:input path="lessonName"/>
  
 <br/>
  <label>Lesson Text</label>
  <form:textarea path="lessonText"/>
   <br/>
   
    <br/>
  <label>Lesson Link</label>
  <form:input path="link"/>
   <br/>
   
  <br/>
  <label>course name</label>
  <form:input path="course.courseName" readonly="true" disabled="true"/>
   <br/>
   
  
   <input type="submit" value="Add Lesson">
 </form:form>
 
 </div>
</body>
</html>