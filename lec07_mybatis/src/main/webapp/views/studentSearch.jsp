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
	<c:choose>
		<c:when test="${ empty student }">
			<p>검색 결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<p>
				${ student.studentNo }
				${ student.studentName }
				${ student.studentAge }
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>