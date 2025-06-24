<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 태그</title>
</head>
<body>
  <%
    List<String> list = new ArrayList<>();
    list.add("사과");
    list.add("바나나");
  %>
  <h2>바구니 크기: <%= list.size() %></h2>
  <ul>
    <li><%= list.get(0) %></li>
    <li><%= list.get(1) %></li>
  </ul>
  <ul>
    <%
      for (String str : list)
        out.print("<li>" + str + "</li>");
    %>
  </ul>
  <ul>
    <% for (String str : list) { %>
      <li><%= str %></li>
    <% } %>
  </ul>
</body>
</html>