<%@page import="com.seleniumexpress.selexplms.entity.Lesson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<%
  Lesson lesson = (Lesson)request.getAttribute("lesson");
  int nextLessonId = lesson.getLessonId() + 1;
  pageContext.setAttribute("nextLessonId", nextLessonId);
  
  int prevLessonId = lesson.getLessonId() - 1;
  pageContext.setAttribute("prevLessonId", prevLessonId);
%>


	<div class="container">
		<h1>${lesson.lessonName}</h1>
		<hr>
		<h2>${lesson.lessonText}</h2>
		<div align="center">
			<h3>Enjoy your lesson</h3>
		</div>
		<div align="center">${lesson.link}</div>
  <!-- next video -->
  <c:if test="${nextLessonId <= lessonCount.lastLessonNumber}">
      <div align="right">
      <a href="/selexp-lms/openLesson?id=${nextLessonId}">next video</a>
      </div>
  </c:if>
    <!-- previous video -->
   <c:if test="${prevLessonId >= lessonCount.firstLessonNumber}">
      <div align="left">
      <a href="/selexp-lms/openLesson?id=${prevLessonId}">previous video</a>
      </div>
  </c:if>
  
	</div>
</body>
</html>