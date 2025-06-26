<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.gn.dto.Product" %>
<% List<Product> list = (List) request.getAttribute("product_list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% 
			if (list != null && !list.isEmpty()) {
				for (Product p : list) {
		%>
					<li><%= p %></li>
		<%
				}
			} else {
				out.println("장바구니가 비어있습니다.");
			}
		%>
	</ul>
</body>
</html>