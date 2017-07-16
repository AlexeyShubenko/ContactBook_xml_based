<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./resources/css/logout.css" rel="stylesheet">
<title>Log out</title>
</head>
<body>
		<div class="divTop">
			<div class="divRight">login: ${user.loginName}</div>	
		</div>
		
		<h1 id="NoteCentr"><spring:message code="title.logout"/></h1>
		<div class="buttons">
		<a href="./exit" class="button"><spring:message code="logOut"/></a>
		<a href="./showContacts" class="button"><spring:message code="returnToMainPage"/></a>
		</div>
</body>
</html>
