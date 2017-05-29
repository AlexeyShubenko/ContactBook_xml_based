<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
	<title>Log in</title>
</head>
<body>

	<form:form method="POST" modelAttribute="loginObject" action="checkLoginUser" class="box">
		<form:label path="loginName">Login:</form:label>
		<form:input path="loginName" name="login" />
		
		<form:label path="password">Password:</form:label>
		<form:password path="password" name="pass"/>
		
		<input type="submit" value="Continue" /> 
		<a href="<c:url value='userRegistration' />">Registration</a><br/>

		<c:choose>
               <c:when test="${edit}">
                 <div class="divErr"><spring:message code="ErrText.isExisting"/></div>
               </c:when>          
            </c:choose>
	</form:form>

</body>
</html>