<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스</title>
</head>
<body>
	<!--
		1. index.jsp에 목록 조회 a태그 생성
		2. 목록 조회 요청을 받는 Servlet(Controller)
		3. Service에 정보 전달
		4. DAO에 데이터베이스 연결 요청
		5. Mapper에 있는 쿼리 실행
	-->
	<ol>
		<li>
			<a href="<c:url value='/student/list'/>">학생 목록 조회</a>
		</li>
	</ol>
	
	<!-- 상품명과 카테고리 기준 상품 검색 -->
	<form action="<c:url value='/product/search'/>" method="get">
		<label>상품명: </label>
		<input type="text" name="productName">
		<label>카테고리: </label>
		<select name="productCategory">
			<option value="0">선택</option>
			<option value="1">전자제품</option>
			<option value="2">의류</option>
			<option value="3">식품</option>
		</select>
		<label>정렬 기준:</label>
		<select name="sort">
			<option value="0">선택</option>
			<option value="1">가격 낮은순</option>
			<option value="2">가격 높은순</option>
			<option value="3">최신순</option>
		</select>
		<input type="submit" value="검색">
	</form>
	
</body>
</html>