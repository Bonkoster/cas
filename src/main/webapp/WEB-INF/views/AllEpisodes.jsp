<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body>
	<div align="center">
		<div class="episodemain">
		<table>
			<c:forEach items="${episodes }" var="episo">
			<div >
			<tr>
				<td class="divbor commentcontent"><a href="/watchEpisode/${episo.id}">${episo.title }</a>    Добавлен ${episo.date}<br><br>
				${episo.desc }
				</td>
			</tr>
			</div>
			</c:forEach>
		</table>
		</div>
	</div>
	<br>
	<div align="center">
<a href="/getSeries/1" class="pagina">Первая</a>
<c:forEach step="1" begin="2" end="${pages - 1}" var="i">
<a href="/getSeries/${i}" class="pagina">${i}</a>
</c:forEach>
<a href="/getSeries/${pages}" class="pagina">Последняя</a>
</div>
</body>
<%@ include file="Footer.jsp" %>
</html>