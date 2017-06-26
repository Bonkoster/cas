<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Введите логин и пароль</title>
</head>
<body>
<div align="center">
	<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post"  class="divbor" >       
	<c:if test="${param.error != null}">        
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="username">Логин</label>
		<input type="text" id="username" name="username" class="fieldBack" />	
	</p>
	<p>
		<label for="password">Пароль</label>
		<input type="password" id="password" name="password" class="fieldBack" />	
	</p>
	<input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn btn-primary">Войти</button>
</form>
</div>
</body>
</html>