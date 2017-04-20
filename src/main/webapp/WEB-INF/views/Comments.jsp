<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body>
<div align="center">
<div class="commentmain">
<c:forEach items="${comments }" var="comment">
<div class="commentcontent">
<div align="left" class="comment">
<c:out value="${comment.author} Написал:">
</c:out>
</div>
<div align="left">
<c:out value="Добавлено: ${comment.date }" >
</c:out><br>
</div>
<div align="left" class="commenttext">
<c:out value="${comment.content }">
</c:out><br>
</div>
</div>
</c:forEach>

<div align="left">
 <form:form action="/cas/addComment" method="POST" modelAttribute="comment" >
 	<table >
 		<tr>
 			<td><form:label path="author" >Author:</form:label></td>
 			<td><form:input path="author"/></td>
 		</tr>
 		<tr>
 			<td><form:label path="content">Content:</form:label></td>
 			<td><form:textarea path="content"/></td>
 		</tr>
 		<tr>
 			<td> <input type="submit" value="Post" class="btn btn-primary"></td>
 		</tr>
 	</table>
 </form:form>
 </div>
 </div>
 </div>
</body>
</html>