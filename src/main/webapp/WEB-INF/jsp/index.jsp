<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Intranet</title>
</head>
<body>
	<%@include file="navBar.jsp"%>

	<div class="main">
		<div class="presentation">
			<h2>Présentation</h2>
			<!-- text pres -->
			<p>Fondée en 1905, l’ESME Sudria forme des ingénieurs
				multidisciplinaires, professionnels majeurs dans les secteurs des
				technologies d’avenir : énergie, systèmes et environnement ;
				systèmes embarqués et électronique ; images, signaux et réseaux,
				intelligence numérique et data. Trois composantes font la modernité
				de sa pédagogie : l’importance de l’esprit d’innovation ;
				l’omniprésence du projet et de l’initiative ; une très large
				ouverture internationale, humaine et culturelle. Depuis sa création,
				près de 14 000 ingénieurs ont été diplômés. L'école délivre un
				diplôme reconnu par l'Etat et accrédité par la CTI.</p>
			<!-- End text pres -->
			
		</div>

		<div class="news">
			<%@include file="displayNews.jsp"%>
		</div>
		
		<div class="contact">
			<h2>Contacts</h2>
			<li>
				<a href="https://www.facebook.com/ESME.Sudria"> phassebouque</a>
			</li>
			<li>
				<a href="http://twitter.com/ESMESudria"> touitteur</a>
			</li>
			<li>
				<a href="https://www.linkedin.com/edu/school?id=12400"> linq'din</a>
			</li>
			<li>
				<a href="https://www.youtube.com/ESMEsudria"> ioutioube</a>
			</li>
			<li>	
				<a href="http://feeds2.feedburner.com/esme-sudria/"> lien</a>
			</li>
		</div>
	</div>

</body>
</html>
