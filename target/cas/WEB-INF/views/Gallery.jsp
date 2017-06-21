<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title2 }</title>
</head>
<body>
		<form:form action="/cas/addImage" modelAttribute="image" method="POST" cssClass="divbor" enctype="multipart/form-data" >
		<table align="center">
			<tr>
				<td><form:label path="title"> Заголовок:</form:label></td>
				<td><form:input path="title" size="100px" cssClass="fieldBack" /></td>
			</tr>
			<tr>
				<td><form:label path="file" >Картинку сюда:</form:label></td>
				<td><form:input path="file" size="100" cssClass="fieldBack"></form:input></td>
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
				<label>${i.title}</label><br>
				<a href="${i.file }" ><img class="imgSize" src="${i.file}"></a>
			</td>
		</c:forEach>
		</tr>
	</table>
	<div class="imgPagin">
	<a href="/cas/galery/1" class="pagina">1</a>
	<c:forEach step="1" begin="2" end="${pages - 1}" var="i">
	<a href="/cas/galery/${i}" class="pagina">${i}</a>
	</c:forEach>
	<a href="/cas/galery/${pages}" class="pagina">${pages}</a>
	</div>
</body>
</html>