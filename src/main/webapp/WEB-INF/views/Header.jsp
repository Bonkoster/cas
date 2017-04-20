<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />" >
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> 
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div class="Astarot"></div>
		<div id="navbarCollapse" class="collapse navbar-collapse darkTheme">
    		<ul class="nav navbar-nav">
      			<li><a href="/cas/hello">Главная страница</a></li>
      			<li><a href="/cas/getSeries">Все серии</a></li>
      			<li><a href="/cas/comments">Отзывы</a></li>
      			<li><a  class="secretfunc" href="/cas/addEpisode">Добавить серию</a> </li>
    		</ul>
  		</div>
 </header>