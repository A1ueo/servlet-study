<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${ studentList }">
				<tr onclick="location.href='/student/detail?no=${s.studentNo}'">
					<td>
						<c:out value="${ s.studentNo }"/>
					</td>
					<td>
						<c:out value="${ s.studentName }"/>
					</td>
					<td>
						<c:out value="${ s.studentAge }"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="<c:url value='/student/insert'/>">학생 등록</a>
	
	
<%-- 	<%@ include file="studentDetail.jsp" %> --%>
	<form action="<c:url value='/student/search'/>" method="get" id="searchName">
		<input type="text" name="student_name" id="name">
		<input type="submit" value="이름 기준 검색">
	</form>
	<%@ include file="studentSearch.jsp" %>



<%--
	<div id="searchResult"></div>
	<script type="text/javascript">
		$(function() {
			$('#searchName').submit(function(e) {
				e.preventDefault();
				const name = $('#name').val();
				$.ajax({
					url: '/student/search?student_name=' + name,
					type: 'get',
					success: function() {
						console.log('비동기 수신 성공');
						$('#searchResult').load('/views/studentSearch.jsp');
					},
					error: function() {
						console.log('비동기 수신 실패');
					},
				});
			});
		});
	</script>
--%>
</body>
</html>