<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Notes</title>
</head>
<body>
	<%@include  file="navBar.jsp" %>
	<div class="main">
		<h2>${a_success}</h2>
		<form action="/addNote" method="post">
			<div class="adduser_container">
				<label for="student"><b>Student</b></label>
			    <select name="student">
				    <c:forEach items="${a_students}" var="curr_student">
						<option value="${curr_student.id_student}">${curr_student.name}</option>
					</c:forEach>
			  	</select>
			  	
			  	<label for="course"><b>Course</b></label>
			    <select name="course">
				    <c:forEach items="${a_courses}" var="curr_course">
						<option value="${curr_course.id_course}">${curr_course.name}</option>
					</c:forEach>
			  	</select>
			  	
			  	<label for="note"><b>Note</b></label>
			    <input type="text" placeholder="15" name="value" required>
			    <button type="submit">Ajouter</button>
			</div>
		</form>
	</div>
</body>
</html>