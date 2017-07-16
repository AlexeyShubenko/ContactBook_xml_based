<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./resources/css/contactFile.css" rel="stylesheet">
	<title>All contacts</title>
</head>
<body>
	
		<div class="divTop">
			<a href="/logOut" class="logOutRef">Log out</a>
			<div class="divRight">login: ${userDto.loginName}</div>
			<a class="addContact" href="./addContact"><spring:message code="button.value.addcontact"/></a>
		</div>
			
			<form:form method="POST" modelAttribute="searcher" action="search" class="search" >
				<form:label path="searcher" ></form:label>
				<form:input path="searcher"/>
	 			<form:radiobutton path="flag" value="true"  />By first name/By last name
				<form:radiobutton path="flag" value="false"/>By mobile phone	
				<input type="submit" value='<spring:message code="button.value.search"/>' class="button" >
			</form:form>
		
			
		<h1 id="NoteCentr"><spring:message code="title.showcontacts"/></h1>
	  <table style="{width: 70%;}">
	  		<tr> 
				<th><spring:message code="contact.params.firstname"/></th>
				<th><spring:message code="contact.params.lastname"/></th>
				<th><spring:message code="contact.params.middlename"/></th>
				<th><spring:message code="contact.params.mobPhoneNumber"/></th>
				<th><spring:message code="contact.params.homePhoneNumber"/></th>
				<th><spring:message code="contact.params.address"/></th>
				<th>Email</th>
			</tr>		
		<c:forEach items="${contactsDto}" var="contactDto">
			<tr>
				<td>${contactDto.firstName} </td>
				<td>${contactDto.lastName}</td>
				<td>${contactDto.middleName}</td>
				<td>${contactDto.mobPhoneNumber}</td>
				<td>${contactDto.homePhoneNumber}</td>
				<td>${contactDto.address}</td>
				<td>${contactDto.email}</td>
				<td id="noneBorder"><a class="button" href="./deleteContact/${contactDto.contact_id}">delete</a></td>
				<%--<td id="noneBorder"><a class="button" href="./editContact/${contactDto.contact_id}">update</a></td>--%>
				<td id="noneBorder"><a class="button" href="./${contactDto.contact_id}">update</a></td>
			</tr>
		</c:forEach>	
	  </table>

</body>
</html>
