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
				<td class="divbor commentcontent"><a href="/cas/watchEpisode/${episo.id}">${episo.title }</a>    Добавлен ${episo.date}<br><br>
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
<a href="/cas/getSeries/1" class="pagina">1</a>
<c:forEach step="1" begin="2" end="${pages - 1}" var="i">
<a href="/cas/getSeries/${i}" class="pagina">${i}</a>
</c:forEach>
<a href="/cas/getSeries/${pages}" class="pagina">${pages}</a>
</div>
</body>
</html>