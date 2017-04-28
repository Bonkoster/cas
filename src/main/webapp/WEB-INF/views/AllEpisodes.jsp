<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title }</title>
</head>
<body>
	<div align="center">
		<div class="episodemain">
		<table>
			<c:forEach items="${episodes }" var="episo">
			<div>
			<tr>
				<td class="divbor"><a href="/cas/watchEpisode/${episo.id}">${episo.title }</a><br></td>
			</tr>
			</div>
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>

			<label >${episo.desc }</label>