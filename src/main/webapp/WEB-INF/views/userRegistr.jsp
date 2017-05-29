<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/registUpdate.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>

<body>
	
	<form:form method="POST" modelAttribute="newUserDto" action="saveNewUser" >
	<h1 id="NoteCentr"><spring:message code="title.login"/></h1>
	  <table>

	  	<tr>
			<td id="head"><form:label path="loginName"><spring:message code="User.params.loginName"/>:</form:label></td>
			<td><form:input path="loginName"/></td>
			<td><form:errors class="textErr" path="loginName" /><td>
		</tr>
	  	
	  	<tr>
			<td id="head"><form:label path="password"><spring:message code="User.params.password"/>:</form:label></td>
			<td><form:input path="password"/></td>
			<td><form:errors class="textErr" path="password" /><td>
		</tr>
	  	
		<tr>
			<td id="head"><form:label path="fio"><spring:message code="User.params.fio"/>:</form:label></td>
			<td><form:input path="fio"/></td>
			<td><form:errors class="textErr" path="fio" /></td>
		</tr>
					
 	  </table>
 	  	
			<input type="submit" class="button" value="<spring:message code="Button.value.save"/>">
			<a href="<c:url value='/startPage'/>" class="button"><spring:message code="ReturnToStartPage"/></a>
		
			<c:choose>
               <c:when test="${edit1}">
                 <div class="divErr"><spring:message code="ErrText.registration.errSymbols"/></div>
               </c:when>          
            </c:choose>         
			
			<c:choose>
               <c:when test="${edit2}">
                 <div class="divErr"><spring:message code="ErrText.registration.errExist"/></div>
               </c:when>          
            </c:choose>
					 
	</form:form>

</body>
</html>