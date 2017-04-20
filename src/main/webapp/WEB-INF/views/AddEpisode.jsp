<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body>
	<form:form action="/cas/addEpisodeAction" modelAttribute="episode" method="POST">
		<table>
			<tr>
				<td><form:label path="title" > Title:</form:label></td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td><form:label path="link" > Link:</form:label></td>
				<td><form:input path="link"/></td>
			</tr>
			<tr>
				<td><form:label path="desc" > Description:</form:label></td>
				<td><form:textarea path="desc"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Upload" class="btn btn-primary"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>