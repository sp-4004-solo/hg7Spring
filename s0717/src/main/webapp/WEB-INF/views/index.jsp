<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>index페이지</h1>
		<h2>${sessionId }님</h2>
			<ul>
				<li><a href="/index">메인화면</a></li>
				<li><a href="/member/join">회원가입</a></li>
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/board/blist">게시판리스트</a></li>
				<li><a href="/board/bwrite">글쓰기</a></li>
				<li><a href="/member/mlist">글보기</a></li>
			</ul>
		

	<body>
</html>