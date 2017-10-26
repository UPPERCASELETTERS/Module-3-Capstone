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
				<form:input path = "emailAddress" />
				<form:errors path="emailAddress" cssClass="error"/>
				<form:errors path="emailAvailable" cssClass="error"/>
		</div>
		<div>
			<label for ="parkCode">Park Code: </label>
			<form:select path = "parkCode">
				<form:option value = "">Select</form:option>
				<c:forEach var = "park" items = "${parks}">
					<form:option value = "${park.parkCode}">
						<c:out value = "${park.parkCode}"/>
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="parkCode" cssClass="error"/>

		</div>
		<div>
			<label for ="state">State of Residence: </label>
			<form:select path = "state">
				<form:option value = "">Select</form:option>
				<c:forEach var = "state" items = "${formFiller.states}">
					<form:option value = "${state}">
						<c:out value = "${state}"/>
					</form:option>
				</c:forEach>
			<form:errors path="state" cssClass="error"/>
			</form:select>
		</div>
		<div>
			<label for ="activityLevel">Level of Physical Activity: </label>
			<form:select path = "activityLevel">
				<form:option value = "">Select</form:option>
				<c:forEach var = "activityLevel" items = "${formFiller.activityLevel}">
					<form:option value = "${activityLevel}">
						<c:out value = "${activityLevel}"/>
					</form:option>
				</c:forEach>
			<form:errors path="activityLevel" cssClass="error"/>
			</form:select>
		</div>
		<br/>
		<input type="submit" value="Submit"/>
		
	</form:form>

<%@include file="common/footer.jspf" %>