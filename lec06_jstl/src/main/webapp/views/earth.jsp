<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Planet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Planet earth = new Planet("지구", 1.5, true);
		request.setAttribute("earth", earth);
	%>
	<p>이름: ${ earth.name }</p>
	<p>태양으로부터 거리: ${ earth.distanceFromSun }억km</p>
	<p>거주 가능 여부: ${ earth.habitable ? "O" : "X" }</p>
</body>
</html>

