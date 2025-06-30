<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
	<%@ include file="views/earth.jsp" %>
	<%@ include file="views/elOperator.jsp" %>
	
	
	<h1>6. 사이트 테마 설정</h1>
	<form method="post" action="/setTheme">
	    <button type="submit" name="theme" value="dark">다크모드</button>
	    <button type="submit" name="theme" value="light">라이트모드</button>
	</form>
	
	
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
	
	
	<h1>5. JSTL Core Library</h1>
	<h2>(1) 변수 선언</h2>
	<!--
		c:set 사용
		1. 자료형 선언하지 않음
		2. 초기값 반드시 작성
		3. c:set으로 지정한 값을 스크립틀릿에서 꺼내 쓸 수 없음
		스크립틀릿에서 setting한 값은 jstl에서 꺼내쓸 수 있음
	-->
	<c:set var="num3" value="10" scope="page"/>
	<c:set var="num4" value="20"/>
	<c:set var="plus" value="${ num3 + num4 }"/>
	
	<h2>(2) 변수 출력</h2>
	<c:set var="result" value="<b>안녕하세요!</b>"/>
	<c:out value="${ result }"/>
	<br>
	<c:out value="${ result }" escapeXml="false"/>
	${ result }
	
	<h2>(3) 조건문: if</h2>
	<c:if test="${ num3 le num4 }">
		<p>num3가 num4보다 작거나 같네요~</p>
	</c:if>
	
	<h2>(4) 조건문: choose</h2>
	<c:choose>
		<c:when test="${ num3 gt 20 }">
			<p>num3 > 20</p>
		</c:when>
		<c:when test="${ num3 ge 10 }">
			<p>10 <= num3 <= 20</p>
		</c:when>
		<c:otherwise>
			<p>num3 < 10</p>
		</c:otherwise>
	</c:choose>
	
	<h2>(5) 반복문: forEach</h2>
	<!-- 기본 for문 처럼 사용하기 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>반복 숫자: ${ i }</p>
	</c:forEach>
	
	<!-- 향상된 for문 처럼 사용하기 -->
	<%
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	<ul>
		<c:forEach var="color" items="${ colors }">
			<li style="color: ${ color }">${ color }</li>
		</c:forEach>
	</ul>
	
	<!-- varStatus 속성 -->
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p>
			숫자: ${ num }, 인덱스: ${ vs.index }, 카운트: ${ vs.count },
			첫번째?: ${ vs.first }, 마지막: ${ vs.last }
		</p>
	</c:forEach>
	
	<h2>(6) 경로: 기존 vs jstl</h2>
	<script src="<%= request.getContextPath() %>/resources/jquery-3.7.1.js">
	</script>
	<a href="<%= request.getContextPath() %>/boardList">게시판</a>
	
	<script src="<c:url value='/resources/jquery-3.7.1.js'/>">
	</script>
	<a href="<c:url value='/boardList'/>">게시판</a>
	<!-- 파라미터 사용하기 -->
	<c:url var="testUrl" value="/boardList">
		<c:param name="nowPage" value="1"/>
	</c:url>
	<a href="${ testUrl }">게시판</a>
	
	
	<h1>8. JSTL Formatting Library</h1>
	<h2>(1) 숫자 정보 포맷팅</h2>
	<fmt:formatNumber value="1234.567" type="number"/>
	<br>
	<fmt:formatNumber value="0.875" type="percent"/>
	<br>
	<fmt:formatNumber value="1234.567" pattern="#,###.##"/>
	<br>
	<fmt:formatNumber value="1234.5" pattern="00000.00"/>
	<br>
	
	<h2>(2) 날짜 정보 포맷팅</h2>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	<fmt:formatDate value="${ now }" type="date"/>
	<br>
	<fmt:formatDate value="${ now }" pattern="yy.MM.dd(E) a hh:mm:ss z"/>
	<br>
	
	
	<h1>9. JSTL Function Library</h1>
	<c:set var="data" value="How Are You? I am fine"/>
	<p><c:out value="${ data }"/></p>
	<p><c:out value="${ fn:toUpperCase(data) }"/></p>
	<p><c:out value="${ fn:replace(data, 'fine', 'apple') }"/></p>
	
</body>
</html>




