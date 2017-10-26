<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>
<br>
<br>
<c:forEach items="${parksList}" var="park">

<c:url value="/detail?parkCode=${park.parkCode}" var="parkDetailURL"/>
<a href="${parkDetailURL}">

	<div id="homeParkContainer">
	
		<div id="homeImageItem">
			<c:url var="parkImageUrl" value="${park.parkImageURL}"/>
			<img src="${parkImageUrl}"/>
		</div> 
		
		<div id="homeInfoItem">
			<strong><c:out value="${park.parkName}"/></strong><br>
			<c:out value="${park.parkDescription}"/>
		</div> 
		
	</div>
</a>
</c:forEach>

<%@include file="common/footer.jspf" %>