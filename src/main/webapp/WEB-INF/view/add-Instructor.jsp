<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%@include file="menu.jsp" %>

<div class="container">
<h1>Add Instructor</h1>
 <form:form action="submit-instructor" method="POST" modelAttribute="instructor">
   <label>Name : </label>
   <form:input path="name"/>
    <br/>
   <label>Exp : </label>
   <form:input path="teachingExp"/>
    <br/>
   <label>Email : </label>
   <form:input path="emai"/>
   <br/>
  <input type="submit" value="Add"> </form:form> 
</div>
</body>
</html>