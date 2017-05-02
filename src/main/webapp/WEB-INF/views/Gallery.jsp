<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${image }</title>
</head>
<body>
		<form:form action="/cas/addImage" modelAttribute="image" method="POST" cssClass="divbor">
		<table align="center">
			<tr>
				<td><form:label path="title"> Заголовок:</form:label></td>
				<td><form:input path="title" size="100px" cssClass="fieldBack" /></td>
			</tr>
			<tr>
				<td><form:label path="mpfile" >Картинку сюда:</form:label></td>
				<td><input type="file" name="mpfile" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="${butto}" class="btn btn-primary"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>