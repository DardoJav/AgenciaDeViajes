<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airline List Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h1 align="center">
	Add Airline
</h1>

<c:url var="addAction" value="/save" ></c:url>

<form:form action="${addAction}" commandName="airline">
<table border="0" align="center">

	<c:if test="${!empty airline.name}">
	<tr>
		<td>
			<form:label path="idAirline">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="idAirline" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idAirline" />
		</td> 
	</tr>
	</c:if>

	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	
	<tr>
		<td colspan="1">
			<c:if test="${empty airline.name}">
				<input type="submit"
					value="<spring:message text="Add Airline"/>" />
			</c:if>
		</td>
		<td colspan="2">
			<c:if test="${!empty airline.name}">
				<input type="submit"
					value="<spring:message text="Edit Airline"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>

<c:if test="${!empty airlines}">
<h3 align="center">Airlines List</h3>
<table border="1" align="center">
    <thead>
        <tr>
            <th width="50" >
                <h3> Name </h3>
            </th>
            <th width="50">
                <h3> Edit </h3>
            </th>
            <th width="50">
                <h3> Delete </h3>
            </th>
            <th width="50">
                <h3> See Planes assigned </h3>
            </th>
        </tr>
        
    </thead>
			<tbody>
				<c:forEach items="${airlines}" var="airline">
					<tr>
						<td width="80">${airline.name}</td>
						<td><a href="<c:url value='/edit/${airline.idAirline}' />">Edit</a>
						</td>
						<td><a href="<c:url value='/delete/${airline.idAirline}' />">Delete</a>
						</td>
						<td><a
							href="<c:url value='/planeList/${airline.idAirline}' />">PlaneList</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>


</body>
</html>