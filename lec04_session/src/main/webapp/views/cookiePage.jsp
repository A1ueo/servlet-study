<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/saveNick" method="post">
    <input type="text" name="nickname" placeholder="닉네임을 적으세요">
    <button>입력</button>
  </form>
  <form action="/removeNick" method="post">
    <button>닉네임 삭제</button>
  </form>
  <%
  	String userNick = null;
  	Cookie[] cookies = request.getCookies();
  	if (cookies != null) {
  		for (Cookie cookie : cookies) {
  			if ("nickname".equals(cookie.getName())) {
  				userNick = cookie.getValue();
  			}
  		}
  	}
  %>
  
  <p>닉네임: <%= userNick %></p>
</body>
</html>