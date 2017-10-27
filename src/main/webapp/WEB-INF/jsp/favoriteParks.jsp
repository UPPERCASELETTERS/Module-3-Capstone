<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Favorite Parks"/>
<%@include file="common/header.jspf" %>
<br>
<br>
<h3>Thank you for filling our survey, <c:out value = "${survey.emailAddress}"/></h3>
<table>
	<tr>
		<th> Park </th>
		<th> Score </th>
	</tr>
	<c:forEach var = "parkRank" items = "${parkRanking}">
		<tr>
			<td><c:out value = "${parkRank.parkName}"/></td>
			<td><c:out value = "${parkRank.count}"/></td>
		</tr>
	</c:forEach>
	
</table>
<%@include file="common/footer.jspf" %>