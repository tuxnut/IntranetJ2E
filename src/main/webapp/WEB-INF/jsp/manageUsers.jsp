<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Comptes</title>
</head>
<body>
	<%@include  file="navBar.jsp" %>
	<div class="main">
		<h2>${a_success}</h2>
		<form action="/addUser" method="post">
			<div class="adduser_container">

		    	<label for="lastname"><b>Nom</b></label>
			    <input type="text" placeholder="Enter Lastname" name="lastname" required>
		    
		   		<label for="firstname"><b>Prénom</b></label>
			    <input type="text" placeholder="Enter Firstname" name="firstname" required>
			    
			    <label for="gender"><b>Civilité</b></label>
			    <input type="radio" name="gender" value="male">M
  				<input type="radio" name="gender" value="female">Mme
  				
  				<br>
				<p>${a_errors["key_email"]}</p>
				<label for="email"><b>Email</b></label>
			    <input type="text" placeholder="Enter Email" name="email" required> 
			    
			    <p>${a_errors["key_password"]}</p>
			    <label for="password"><b>Mot de passe</b></label> 
			    <input type="password" placeholder="Enter Password" name="password" required>
			    
			    <label for="password2"><b>Confirmation</b></label>
			    <input type="password" placeholder="Enter Password" name="password2" required> 
			    
			    <label for="type"><b>Type</b></label>
			    <select name="type">
				    <option value="admin">Administrateur</option>
				    <option value="teacher">Enseignant</option>
				    <option value="student">Elève</option>
			  	</select>
			  	
			  	<label for="section"><b>Classe (si elève)</b></label>
			    <select name="section">
				    <c:forEach items="${a_sections}" var="curr_section">
						<option value="${curr_section.name}">${curr_section.name}</option>
					</c:forEach>
			  	</select>
			
			    <button type="submit">Créer</button>
		    </div>
		</form>
	</div>
</body>
</html>