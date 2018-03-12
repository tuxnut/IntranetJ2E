<style>
	<%@include  file="../css/navBar_style.css" %>
</style>
<div class="navBar">
	<ul>
	    <li>
	        <a href="${pageContext.request.contextPath}/Home">Home</a>
	    </li>
	    <li>
	        <a href="${pageContext.request.contextPath}/News">News</a>
	    </li>
	    
	    <% if (request.getAttribute("a_userType").equals("admin")) { %>
	    <li>
	        <a href="${pageContext.request.contextPath}/GestionNews">Gestion News</a>
	    </li>
	    <li>
	        <a href="${pageContext.request.contextPath}/GestionComptes">Gestion Comptes</a>
	    </li>
	    <% } %>
	    <% if (request.getAttribute("a_userType").equals("teacher")) { %>
	    <li>
	        <a href="${pageContext.request.contextPath}/GestionNotes">Gestion Notes</a>
	    </li>
	    <% } %>
	    <% if (request.getAttribute("a_userType").equals("student")) { %>
	    <li>
	        <a href="${pageContext.request.contextPath}/MesNotes">Mes Notes</a>
	    </li>
	    <li>
	        <a href="${pageContext.request.contextPath}/EmploiDuTemps">Emploi du Temps</a>
	    </li>
	    <% } %>
	    <% if (request.getAttribute("a_userType").equals("")) { %>
	    <li style="float:right">
	        <button id="bt_login" onclick="document.getElementById('id01').style.display='block'">Login</button>
	    </li>
	    <% } %>
	    <% if (!request.getAttribute("a_userType").equals("")) { %>
		<li style="float:right">
	        <button id="bt_logout" onclick="document.getElementById('id02').style.display='block'">Logout</button>
	    </li>
	    <% } %>
	</ul>
</div>

<%@include file="log.jsp" %>