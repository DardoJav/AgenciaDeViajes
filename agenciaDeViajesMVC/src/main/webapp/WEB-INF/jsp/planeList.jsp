<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of planes for Airline ${airline.name} </title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<c:if test="${!empty planes}">
<h3 align="center">List of planes for Airline ${airline.name}</h3>
<table border="1" align="center">
    <thead>
        <tr>
            <th width="50" >
                <h3> Model </h3>
            </th>
            <th width="50">
                <h3> Serial Number </h3>
            </th>
            <th width="50">
                <h3> Hours Flown </h3>
            </th>
            <th width="50">
                <h3> Color </h3>
            </th>
        </tr>
        
    </thead>
    <tbody>
  <c:forEach items="${planes}" var="plane">
            <tr>
                <td width="80">${plane.model}</td>
                <td width="80">${plane.serialNumber}</td>
                <td width="80">${plane.hoursFlown}</td>
                <td width="80">${plane.color}</td>
<!--                 <td> -->
<%--                 	<a href="<c:url value='/edit/${airline.idAirline}' />" >Edit</a> --%>
<!--                 </td> -->
<!-- 				<td> -->
<%-- 					<a href="<c:url value='/delete/${airline.idAirline}' />" >Delete</a> --%>
<!-- 				</td> -->
<!-- 				<td> -->
<%-- 					<a href="<c:url value='/planeList/${airline}' />" >Plane List</a> --%>
<!-- 				</td> -->
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>

</body>
</html>