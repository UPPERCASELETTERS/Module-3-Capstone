<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>
<br>
<br>
	
	<c:url var = "surveyURL" value = "/survey"/>
	<form:form method = "POST" action = "${surveyURL}" modelAttribute="survey">
		<div>
				<label for ="emailAddress">Email Address: </label>
				<form:input path = "emailAddress" />*
				<form:errors path="emailAddress" cssClass="error"/>
				<form:errors path="emailAvailable" cssClass="error"/>
		</div>
		<div>
			<label for ="parkCode">Park Code: </label>
			<form:select path = "parkCode">
				<form:option value = "NONE">Select</form:option>
				<c:forEach var = "park" items = "${parks}">
					<form:option items = "${park.parkCode}">
						<c:out value = "${park.parkCode}"/>
					</form:option>
				</c:forEach>
			</form:select>
				
		</div>
		<input type = "hidden" name = "parkCode" value = "${park.parkCode}"/>
		<input type="submit" value="Change Temp Unit"/>
		
	</form:form>

<%@include file="common/footer.jspf" %>