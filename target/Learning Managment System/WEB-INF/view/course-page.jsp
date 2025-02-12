<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<!-- retrive the detail for the course here -->
<h1>${course.courseName}
<a href="/selexp-lms/show-add-lesson?courseId=${courseId}" class="btn btn-warning"> Add Lesson</a>
</h1>

<hr>
<h3>Lessons</h3>

<spring:url var="viewCourseURL" value="/viewCourse?courseId=${courseId}"></spring:url>

<c:set var="pagedLessonListHolder" value="${lessonList}" scope="session"></c:set>

<c:forEach  var="lesson" items="${pagedLessonListHolder.pageList}">

 <a href="/selexp-lms/openLesson?id=${lesson.lessonId}" class="link-primary">${lesson.lessonName}</a>
 <a href="/selexp-lms/show-add-lesson?courseId=${courseId}&lessonId=${lesson.lessonId}" class="link-dark">Edit</a>
 
 <br/>
</c:forEach>

 <c:choose>
  <c:when test="${pagedLessonListHolder.firstPage}">prev</c:when>
  <c:otherwise>
  <a href="${viewCourseURL}&pageNum=prev">prev</a>
  </c:otherwise>
 </c:choose>

  <c:forEach begin="0" end="${pagedLessonListHolder.pageCount-1}" varStatus="loop">

   <a href="${viewCourseURL}&pageNum=${loop.index}">${loop.index+1}</a> 

</c:forEach>

 <c:choose>
  <c:when test="${pagedLessonListHolder.lastPage}">next</c:when>
  <c:otherwise>
  <a href="${viewCourseURL}&pageNum=next">next</a>
  </c:otherwise>
 </c:choose>


</div>

</body>
</html>