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
<div class="commentcontent divbor" >
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
<div>
<a href="/cas/comments/1">1</a>
<a href="/cas/comments/${pages}">${pages}</>
</div>

<div align="left" class="contentmain">
 <form:form action="/cas/addComment" method="POST" modelAttribute="comment" class="divbor">
 	<table >
 		<tr>
 			<td><form:label path="author" >Автор:</form:label></td>
 			<td><form:input path="author" size="95px" cssClass="fieldBack" /></td>
 		</tr>
 		<tr>
 			<td><form:label path="content">Содержание:</form:label></td>
 			<td><form:textarea path="content" cols="97px" rows="7px" cssClass="fieldBack" /></td>
 		</tr>
 		<tr>
 			<td> <input type="submit" value="${Post }" class="btn btn-primary" align="right"></td>
 		</tr>
 	</table>
 </form:form>
 </div>
 </div>
 </div>
</body>
</html>