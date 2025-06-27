<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
	<%@ include file="views/earth.jsp" %>
	<%@ include file="views/elOperator.jsp" %>
	
	<h1>1. EL의 내장객체</h1>
	<%
		pageContext.setAttribute("test", "페이지");
		request.setAttribute("test", "리퀘스트");
		session.setAttribute("test", "세션");
		application.setAttribute("test", "어플리케이션");
	%>
	<h2>(1) JSP 방식 => 특정 범주 내장객체 지정</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<!--
		1. ~Scope로 끝나는 내장객체 사용
		2. 내장 객체 지정없이 key만 사용: 가장 작은 범주부터 탐색
	-->
	<p>${ pageScope.test }</p>
	<p>${ test }</p>
	
	<h1>2. EL로 객체 다루기</h1>
	<%@ page import="com.gn.dto.Person" %>
	<%
		Person p = new Person("김철수", 77);
		request.setAttribute("person", p);
	%>
	<h2>(1) JSP 방식</h2>
	<%
		Person p1 = (Person) request.getAttribute("person");
	%>
	<p>이름: <%= p1.getName() %></p>
	<p>나이: <%= p1.getAge() %></p>
	
	<h2>(2) EL 방식</h2>
	<!--
		EL 방식으로 객체 정보를 꺼내는 경우: key값.필드명
		private 필드를 직접 꺼내는거 아님!! getter 반드시 필요함
	-->
	<p>이름: ${ person.name }</p>
	<p>나이: ${ person.age }</p>
	
	<h1>4. EL 연산자</h1>
	<%
		request.setAttribute("num1", 7);
		request.setAttribute("num2", 2);
		request.setAttribute("str1", "햄버거");
		request.setAttribute("str2", "피자");
		
		List<String> menu = new ArrayList<>();
		menu.add("짜장면");
		menu.add("짬뽕");
		request.setAttribute("menuList", menu);
	%>
	
	<p>
		산술 연산
		${ num1 + num2 }
		${ num1 - num2 }
		${ num1 * num2 }
		${ num1 div num2 }
		${ num1 mod num2 }
	</p>
	<p>
		문자열 연결, 비교
		${ str1 }${ str2 }
		${ str1 eq str2 }
		${ str1 ne str2 }
	</p>
	<p>
		리스트 데이터 확인
		${ empty menuList ? "메뉴가 비어있어요" : "메뉴가 있어요" }
		${ not empty menuList }
	</p>
	<p>
		대소 비교 & 논리 연산
		${ num1 gt num2 }
		${ num1 lt num2 }
		<br>
		num1이 num2보다 크고, menuList가 비어있지 않은 경우
		${ num1 gt num2 and empty menuList }
	</p>
	
</body>
</html>




