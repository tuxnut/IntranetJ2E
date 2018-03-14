<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des News</title>
</head>
<body>
	<%@include  file="navBar.jsp" %>
	
	<div class="main">
		<h2>${a_success}</h2>
		<form action="/addNews" method="post">
			<div class="adduser_container">
				<label for="title"><b>Title</b></label>
			    <input type="text" placeholder="My title" name="title" required maxlength="255">
			  	
			  	<label for="content"><b>Contents</b></label>
			    <input type="text" placeholder="Content ..." name="content" required maxlength="255">
			  	<button type="submit">Add</button>
			</div>
		</form>
	</div>
</body>
</html>