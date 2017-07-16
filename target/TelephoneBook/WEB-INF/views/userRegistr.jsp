<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./resources/css/registUpdate.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>

<body>

<div>
	<form:form method="POST" modelAttribute="userDto" action="" >
		<h1 id="NoteCentr"><spring:message code="title.login"/></h1>
		<div>
			${error}
		</div>
	  <table>

	  	<tr>
			<td id="head"><form:label path="loginName"><spring:message code="user.params.loginName"/>:</form:label></td>
			<td><form:input path="loginName"/></td>
			<td><form:errors path="loginName" class="textErr"/><td>
		</tr>
	  	
	  	<tr>
			<td id="head"><form:label path="password"><spring:message code="user.params.password"/>:</form:label></td>
			<td><form:input path="password"/></td>
			<td><form:errors path="password" class="textErr"/><td>
		</tr>
	  	
		<tr>
			<td id="head"><form:label path="fio"><spring:message code="user.params.fio"/>:</form:label></td>
			<td><form:input path="fio"/></td>
			<td><form:errors path="fio" class="textErr"/></td>
		</tr>
					
 	  </table>
 	  	
			<input type="submit" class="button" value="<spring:message code="button.value.save"/>">

			<a href="./startPage" class="button"><spring:message code="returnToMainPage"/></a>

	</form:form>
</div>

<%--<c:choose>--%>
	<%--<c:when test="${edit1}">--%>
		<%--<div class="divErr"><spring:message code="ErrText.registration.errSymbols"/></div>--%>
	<%--</c:when>--%>
<%--</c:choose>--%>

<%--<c:choose>--%>
	<%--<c:when test="${edit2}">--%>
		<%--<div class="divErr"><spring:message code="ErrText.registration.errExist"/></div>--%>
	<%--</c:when>--%>
<%--</c:choose>--%>



</body>
</html>
