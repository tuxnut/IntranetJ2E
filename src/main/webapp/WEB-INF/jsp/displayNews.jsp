
<c:forEach items="${a_news}" var="curr_news">
	<h2>${curr_news.title}</h2>
	<br>
	<p>${curr_news.text}</p>
	<br>
	<p id="quote">- ${curr_news.publicationDate}</p>
	<hr>
	<br>
</c:forEach>