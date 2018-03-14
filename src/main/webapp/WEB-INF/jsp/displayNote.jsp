<c:forEach items="${a_notes}" var="curr_note" varStatus="loop">
	<p>${a_courses_name[loop.index]}</p>
	<p>${curr_note.value}</p>
</c:forEach>