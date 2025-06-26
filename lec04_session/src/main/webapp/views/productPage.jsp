<%@page import="com.gn.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.gn.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addToCart">상품 목록
		<% List<Product> list = (List<Product>) request.getAttribute("productList");
			int count = 0;
			for (Product p : list) {
		%>
			<input type="checkbox" >
			<label for="<%= "product" + count %>"><%= p.getName() %></label>
		<%
			count++;
			}
		%>
	</form>

</body>
</html>