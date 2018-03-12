	<style>
		<%@include  file="../css/style.css" %>
	</style>

	<div id="id01" class="modal_login">
	  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
	
	  <form class="modal-content animate" action="/loginProcess" method="post">
	
	    <div class="login_container">
	    	<p>${a_error}</p>
	    
	   		<label for="email"><b>Login</b></label>
		    <input type="text" placeholder="Enter email" name="email" required>
		
		    <label for="password"><b>Password</b></label>
		    <input type="password" placeholder="Enter Password" name="password" required>
		    
		    <label for="type"><b>Type</b></label>
		    <select name="type">
			    <option value="admin">Administrator</option>
			    <option value="teacher">Teacher</option>
			    <option value="student">Student</option>
		  	</select>
		
		    <button type="submit">Login</button>
	    </div>
	  </form>
	</div>
	
	<div id="id02" class="modal_login">
	  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
	
	  <form class="modal-content animate" action="/logoutProcess" method="post">
	
	    <div class="login_container">
	    	<p>${a_error}</p>
	    	<p>LOGOUT ?</p>
		    <button name="answer" value="yes" type="submit">YES</button>
		    <button name="answer" value="no" type="submit">NO</button>
	    </div>
	  </form>
	</div>
	
	<script>
		// Get the modal
		const modal_login = document.getElementById('id01');
		const modal_logout = document.getElementById('id02');
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = (event) => {
		    if (event.target == modal_login) {
		        modal_login.style.display = "none";
		    }
		    if (event.target == modal_logout) {
		        modal_logout.style.display = "none";
		    }
		};
	</script>
