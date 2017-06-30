<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title2 }</title>
</head>
<body>
		<form:form action="/addImage" modelAttribute="image" method="POST" cssClass="divbor">
		<table align="center">
			<tr>
				<td><form:label path="title"> Заголовок:</form:label></td>
				<td><form:input path="title" size="100px" cssClass="fieldBack" /></td>
			</tr>
			<tr>
				<td><form:label path="file" >Ссылку на картинку сюда:</form:label></td>
				<td><form:input path="file" size="100" cssClass="fieldBack" ></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="${butto}" class="btn btn-primary"  ></td>
			</tr>
		</table>
	</form:form>
	
	<table>
		<tr>
		<c:forEach items="${images}" var="i" varStatus="status" >
				<c:if test="${status.index % 4 == 0}">
					</tr>
					<tr>
				</c:if>
			<td align="center" width="400px">
				<label class="commenttext">${i.title}</label><br>
				<a href="${i.file }" ><img class="imgSize" src="${i.file}"></a><br>
				<label class="linktext">${hint }</label>
			</td>
		</c:forEach>
		</tr>
	</table>
	<div class="imgPagin">
	<a href="/galery/1" class="pagina">Первая</a>
	<c:forEach step="1" begin="2" end="${pages - 1}" var="i">
	<a href="/galery/${i}" class="pagina">${i}</a>
	</c:forEach>
	<a href="/galery/${pages}" class="pagina">Последняя</a>
	</div>
</body>
<%@ include file="Footer.jsp" %>
</html>