<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c:if문 사용하려면 꼭 있어야 하는 코드(core 찾아서 자동완성 해야함) -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>메인 페이지</h2>
		<ul>
		<!-- "/나 .은 루트에서 시작해라 하는 의미" -->
		
		<c:if test="${sessionId==null }">
			<h2>로그인해주세요</h2>	
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/join">회원가입</a></li>
		</c:if>
		
		<c:if test="${sessionId!=null }">
			<h2>${sessionName }님 환영합니다.</h2>	
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/member/memList">회원정보</a></li>
			<li><a href="/board/bList">회원정보</a></li>
		</c:if>
		
		</ul>
	</body>
</html>