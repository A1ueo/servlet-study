<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = "관리자";
		Account account = null;
		if (session != null)
			account = (Account) session.getAttribute("account");
		if (account != null 
			&& name.equals(account.getName())) {
	%>
			<p><%= account.getName() %>님 환영합니다!</p>
			<a href="/logout">로그아웃</a>
	<%
		} else {
	%>
			<form action="/login" method="post">
				<label for="user_id">아이디 :</label>
				<input type="text" name="user_id" id="user_id"><br>
				<label for="user_pw">비밀번호 :</label>
				<input type="password" name="user_pw" id="user_pw">
				<input type="submit" value="로그인">
			</form>
	<%	}
	%>
</body>
</html>