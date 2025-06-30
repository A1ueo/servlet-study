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
	<c:forEach var="student" items="${ studentList }">
		<p>
			<c:out value="${ student.studentNo }"/>
			<c:out value="${ student.studentName }"/>
			<c:out value="${ student.studentAge }"/>
		</p>
	</c:forEach>
</body>
</html>