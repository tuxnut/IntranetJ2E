<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Comptes</title>
</head>
<body>
	<%@include  file="navBar.jsp" %>
	<div class="main">
		<form action="/addUser" method="post">
			<div class="adduser_container">
		    	<p>${a_error}</p>

		    	<label for="lastname"><b>Nom</b></label>
			    <input type="text" placeholder="Enter Lastname" name="lastname" required>
		    
		   		<label for="firstname"><b>Prénom</b></label>
			    <input type="text" placeholder="Enter Firstname" name="firstname" required>
			    
			    <label for="gender"><b>Civilité</b></label>
			    <input type="radio" name="gender" value="male">M
  				<input type="radio" name="gender" value="female">Mme
  				
  				<br>
			
				<label for="email"><b>Email</b></label>
			    <input type="text" placeholder="Enter Email" name="email" required>
			    
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
				    <option value="section01">INGE</option>
			  	</select>
			
			    <button type="submit">Créer</button>
		    </div>
		</form>
	</div>
</body>
</html>