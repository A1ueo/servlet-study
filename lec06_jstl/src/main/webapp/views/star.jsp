<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>별 찍기</h1>
	<form action="/countStars" method="post">
		<input type="text" name="num">
		<button>출력</button>
	</form>
	<c:forEach var="i" begin="1" end="${ num }">
		<c:forEach var="j" begin="1" end="${ i }">
			<c:out value="⭐"/>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>