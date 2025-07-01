<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
</head>
<body>
	<form action="<c:url value='/student/insert'/>" method="post">
		<input type="text" placeholder="이름" name="studentName">
		<br>
		<input type="text" placeholder="나이" name="studentAge">
		<br>
		<button>등록</button>
	</form>
</body>
</html>