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
<title>Contact registration</title>
</head>

<body>
	<form:form method="POST" modelAttribute="contactDto" action="saveNewContact">
	<h1 id="NoteCentr"><spring:message code="title.contactRegist"/></h1>
	  <table>	
	  
	  	<tr>
			<td id="head"><form:label path="firstName"><spring:message code="Contact.params.firstname"/>*:</form:label></td>
			<td><form:input path="firstName"/></td>
			<td><form:errors class="textErr" path="firstName" /><td>
		</tr>
	  	
	  	<tr>
			<td id="head"><form:label path="lastName"><spring:message code="Contact.params.lastname"/>*:</form:label></td>
			<td><form:input path="lastName"/></td>
			<td><form:errors class="textErr" path="lastName" /><td>
		</tr>
	  	
		<tr>
			<td id="head"><form:label path="middleName"><spring:message code="Contact.params.middlename"/>*:</form:label></td>
			<td><form:input path="middleName"/></td>
			<td><form:errors class="textErr" path="middleName" /><td>
		</tr>
				
		<tr>
			<td id="head"><form:label path="mobPhoneNumber"><spring:message code="Contact.params.mobPhoneNumber"/>*:</form:label></td>
			<td><form:input path="mobPhoneNumber" placeholder="+380(00)1234567"/></td>
			<td><form:errors class="textErr" path="mobPhoneNumber" /><td>
		</tr>		
					
		<tr>
			<td id="head"><form:label path="homePhoneNumber"><spring:message code="Contact.params.homePhoneNumber"/>:</form:label></td>
			<td><form:input path="homePhoneNumber" placeholder="12-34-56"/></td>
			<t><form:errors class="textErr" path="homePhoneNumber" /><td>
		</tr>
		
		<tr>
			<td id="head"><form:label path="address"><spring:message code="Contact.params.address" />  </form:label></td>
			<td><form:textarea path="address" placeholder="Ukraine, c. Kiev, str. Borschagivska, 148" rows="2" cols="21"/></td>
			<td><form:errors class="textErr" path="address" /><td>
		</tr>
		
		<tr>
			<td id="head"><form:label path="email">Email:</form:label></td>
			<td><form:input path="email" placeholder="test@mail.ua"/></td>
			<td><form:errors class="textErr" path="email" /><td>
		</tr>
					
 	  </table>
 	  
 	  		<c:choose>
               <c:when test="${edit1}">
                 <div class="divErr"><spring:message code="ErrText.registration.errTelNumber"/></div>
               </c:when>          
            </c:choose> 
 	  
 	  		<c:choose>
               <c:when test="${edit2}">
                 <div class="divErr"><spring:message code="ErrText.registration.errHomeNumber"/></div>
               </c:when>          
            </c:choose> 

            <input type="submit" class="button" value="<spring:message code="Button.value.save"/>">
			<a href="<c:url value='/showContacts'/>" class="button"><spring:message code="ReturnToPreviousPage"/></a>
	</form:form>

</body>
</html>
