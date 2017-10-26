<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>
<br>
<br>
	<div class="flexContainer">
		<div id="imageAndQuote">
			<div>
				<c:url var="parkImageUrl" value="${park.parkImageURL}"/>
				<img src="${parkImageUrl}"/>
			</div>
			
			<div id="inspirational">
				<c:out value="${park.inspirationalQuote}"/>
				<c:out value=" - ${park.inspirationalQuoteSource}"/>
			</div>
		</div>	
		
		<div id="nameAndTable">
			<h2>
				<c:out value="${park.parkName}"/>
				<c:out value=" (${park.parkCode})"/>
			</h2>
			
			<table>
			
				<tr>
					<td>Acreage: </td>
					<td><c:out value="${park.acreage}"/></td>
				</tr>
				
				<tr>
					<td>Elevation (ft.): </td>
					<td><c:out value="${park.elevationInFeet}"/></td>
				</tr>
				
				<tr>
					<td>Miles of Trail: </td>
					<td><c:out value="${park.milesOfTrail}"/></td>
				</tr>
				
				<tr>
					<td>No. of Campsites: </td>
					<td><c:out value="${park.numberOfCampsites}"/></td>
				</tr>
				
				<tr>
					<td>Climate: </td>
					<td><c:out value="${park.climate}"/></td>
				</tr>
				
				<tr>
					<td>No. of Animal Species: </td>
					<td><c:out value="${park.numberOfAnimalSpecies}"/></td>
				</tr>
				
				<tr>
					<td>Year Founded: </td>
					<td><c:out value="${park.yearFounded}"/></td>
				</tr>
				
				<tr>
					<td>Annual Visitors: </td>
					<td><c:out value="${park.annualVisitorCount}"/></td>
				</tr>
				
				<tr>
					<td>Entry Fee: </td>
					<td><c:out value="$${park.entryFee}.00"/></td>
				</tr>
			
			</table>
		</div>
	</div>
	
	<br/>
	<br/>
	 
	<div>
		<c:out value="${park.parkDescription}"/>
	</div>

	<c:set var = "first" value = "true"/>
	<c:forEach var ="weather" items = "${fivecast}">
		<c:url var = "weatherImageURL" value = "${weather.forecastImageURL}"/>
		<c:choose>
			<c:when test = "${first}">
				<c:set var = "first" value = "false"/>
				<h3>Today</h3>
				<span id = "todaysWeather">
					<img src = "${weatherImageURL}" id ="todayImage"/><br/>
					<c:choose>
						<c:when test = "${tempStyle == 'c'}">
							<fmt:formatNumber var="high" value=	"${(weather.high-32)*5/9}" maxFractionDigits="1"/>					
							<fmt:formatNumber var="low" value=	"${(weather.low-32)*5/9}" maxFractionDigits="1"/>
							<c:out value = "High: ${high}"/>
							<c:out value = "Low: ${low}"/><br/>
						</c:when>
						<c:otherwise>
							<c:out value = "High: ${weather.high}"/>
							<c:out value = "Low: ${weather.low}"/><br/>
						</c:otherwise>
					</c:choose>
					<c:out value = "${weather.recommendation}"/>
					<c:if test = "${weather.tooHot}">Bring an extra gallon of water.</c:if>
					<c:if test = "${weather.tooCold}">Be careful, it's cold.</c:if>
					<c:if test = "${weather.varying}">Wear breathable clothes.</c:if><br/><br/>
				</span>
			</c:when>
			<c:otherwise>
				<span id = "futureWeather">
					<img src = "${weatherImageURL}" class = "notTodayImage"/><br/>
					<c:choose>
						<c:when test = "${tempStyle == 'c'}">
							<fmt:formatNumber var="high" value=	"${(weather.high-32)*5/9}" maxFractionDigits="1"/>					
							<fmt:formatNumber var="low" value=	"${(weather.low-32)*5/9}" maxFractionDigits="1"/>
							<c:out value = "High: ${high}"/>
							<c:out value = "Low: ${low}"/><br/>
						</c:when>
						<c:otherwise>
							<c:out value = "High: ${weather.high}"/>
							<c:out value = "Low: ${weather.low}"/><br/>
						</c:otherwise>
					</c:choose>
				</span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:url var = "changeTempURL" value = "/detail"/>
	<form method="POST" action = "${changeTempURL}">
		<c:choose>
			<c:when test = "${tempStyle == 'c'}">
				<input type = "hidden" name = "tempStyle" value = "f"/>
			</c:when>
			<c:otherwise>
				<input type = "hidden" name = "tempStyle" value = "c"/>
			</c:otherwise>
		</c:choose>
		<input type = "hidden" name = "parkCode" value = "${park.parkCode}"/>
		<input type="submit" value="Change Temp Unit"/>
	</form>

<%@include file="common/footer.jspf" %>