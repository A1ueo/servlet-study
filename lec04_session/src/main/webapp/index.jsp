<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<%@include file="views/login.jsp" %>

	<h1>Cookie</h1>
	<ul>
		<li><a href="/makeCookie">쿠키 생성🍪</a></li>
		<li><a href="/editCookie">쿠키 수정🍪🍪</a></li>
		<li><a href="/deleteCookie">쿠키 삭제</a></li>
		<li><a href="/practiceCookie">쿠키 연습하기</a></li>
		<li><a href="/changePage">방문 횟수 추적하기</a></li>
	</ul>

	<h2>현재 쿠키 값 확인</h2>
	<%
	// 1. 클라이언트가 보낸 쿠키 배열 가져오기
	Cookie[] cookies = request.getCookies();
	String userId = "쿠키 없음";
	// 2. 쿠키 배열에서 원하는 쿠키 찾기
	Map<String, String> cookieMap = new HashMap<>();
	if (cookies != null) {
		for (Cookie c : cookies) {
			cookieMap.put(c.getName(), c.getValue());
			/* if ("user_id".equals(c.getName())) {
				userId = c.getValue();
				break;
			} */
		}
	}
	userId = cookieMap.get("user_id");
	String nickname = cookieMap.get("nickname");
	if (nickname == null)
		nickname = "____";
	%>

	<p>user_id 쿠키값: <%= userId %></p>
	<p>닉네임: <%= nickname %></p>
	
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/updateSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
		<li>
			<a href="/productList">상품 목록</a>
		</li>
	</ol>
	
	<%
		String memeberId = "세션 없음";
		if (session != null) { // session은 내장 객체
			if (session.getAttribute("member_id") != null) {
				memeberId = (String) session.getAttribute("member_id");
			}
		}
	%>
	<p>세션 정보: <%= memeberId %></p>
	
</body>
</html>