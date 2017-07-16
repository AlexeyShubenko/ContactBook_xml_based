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
<title>Contact update</title>
</head>

<body>
	<form:form method="POST" modelAttribute="contactDto">
		<h1 id="NoteCentr"><spring:message code="title.update"/></h1>
		  <table>

			<tr>
				<td id="head"><form:label path="firstName"><spring:message code="contact.params.firstname"/>*:</form:label></td>
				<td><form:input path="firstName" value="${contact.firstname}"/></td>
				<td><form:errors class="textErr" path="firstName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="lastName"><spring:message code="contact.params.lastname"/>*:</form:label></td>
				<td><form:input path="lastName" value="${contact.lastname}"/></td>
				<td><form:errors class="textErr" path="lastName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="middleName"><spring:message code="contact.params.middlename"/>*:</form:label></td>
				<td><form:input path="middleName" value="${contact.middlename}"/></td>
				<td><form:errors class="textErr" path="middleName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="mobPhoneNumber"><spring:message code="contact.params.mobPhoneNumber"/>*:</form:label></td>
				<td><form:input path="mobPhoneNumber" placeholder="+380(00)1234567" value="${contact.mobPhoneNumber}" /></td>
				<td><form:errors class="textErr" path="mobPhoneNumber" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="homePhoneNumber"><spring:message code="contact.params.homePhoneNumber"/>:</form:label></td>
				<td><form:input path="homePhoneNumber" placeholder="12-34-56" value="${contact.homePhoneNumber}"/></td>
				<td><form:errors class="textErr" path="homePhoneNumber" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="address"><spring:message code="contact.params.address" />  </form:label></td>
				<td><form:textarea path="address" placeholder="Ukraine, c. Kiev, str. Borschagivska, 148"
					rows="2" cols="21" value="${contact.address}"/></td>
				<td><form:errors class="textErr" path="address" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" placeholder="test@mail.ua" value="${contact.email}"/></td>
				<td><form:errors class="textErr" path="email" /><td>
			</tr>

		  </table>

		<div class="divErr">
			${error1}
		</div>
		<div class="divErr">
				${error2}
		</div>
				<%--<c:choose>--%>
				   <%--<c:when test="${edit1}">--%>
					 <%--<div class="divErr"><spring:message code="errText.registration.errTelNumber"/></div>--%>
				   <%--</c:when>--%>
				<%--</c:choose>--%>

				<%--<c:choose>--%>
				   <%--<c:when test="${edit2}">--%>
					 <%--<div class="divErr"><spring:message code="errText.registration.errHomeNumber"/></div>--%>
				   <%--</c:when>--%>
				<%--</c:choose>--%>

		<input type="submit" class="button" value="<spring:message code="button.value.update"/>">
		<a href="./showContacts" class="button"><spring:message code="returnToPreviousPage"/></a>

	</form:form>


</body>
</html>
