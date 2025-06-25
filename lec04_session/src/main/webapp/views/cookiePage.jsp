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
    <input type="text" name="nickname">
    <button>입력</button>
  </form>
  <form action="/removeNick" method="post">
    <button>닉네임 삭제</button>
  </form>
</body>
</html>