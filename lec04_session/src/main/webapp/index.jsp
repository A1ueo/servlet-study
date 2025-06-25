<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
  <h1>Cookie</h1>
  <ul>
    <li>
      <a href="/makeCookie">쿠키 생성🍪</a>
    </li>
    <li>
      <a href="/editCookie">쿠키 수정🍪🍪</a>
    </li>
    <li>
      <a href="/deleteCookie">쿠키 삭제</a>
    </li>
    <li>
      <a href="/practiceCookie">쿠키 연습하기</a>
    </li>
    <li>
      <a href="/changePage">방문 횟수 추적하기</a>
    </li>
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
</body>
</html>