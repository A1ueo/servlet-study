<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.gn.dto.Product" %>
<%@page import="com.gn.dto.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addToCart" method="post">
		<select name="product">
			<% List<Product> list = (List<Product>) request.getAttribute("productList");
				int count = 0;
				for (Product p : list) {
			%>
				<!-- params로 넘기기 -->
				<option value="<%= p.getName() %>"><%= p.getName() %></option>
			<%
				count++;
				}
			%>
		</select>
		<button>장바구니에 추가</button>
	</form>
	<a href="/cartList">장바구니 보기</a>

</body>
</html>