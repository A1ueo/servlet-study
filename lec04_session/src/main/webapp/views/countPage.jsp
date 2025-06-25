<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Cookie[] cookieArr = request.getCookies(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    int count = 0;
    for (Cookie cookie : cookieArr) {
      if ("visit_count".equals(cookie.getName())) {
        count = Integer.parseInt(cookie.getValue());
      }
    }
  %>
  <p>당신은 이 페이지를 <strong><%= count + 1 %></strong>번 방문했습니다.</p>
</body>
</html>