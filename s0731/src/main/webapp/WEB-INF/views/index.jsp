<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		${sessionNicName}님 환영합니다 
		<ul>
			<li><a href="checkbox">체크박스연습</a></li>
			<li><a href="inputCheck">입력연습</a></li>
			<li><a href="sendEmail">이메일보내기</a></li>
		</ul>
		<h1>member</h1>
		<ul>
			<li><a href="/member/step02">회원가입(동의)</a></li>
			<li><a href="/member/step03">회원가입(가입)</a></li>
			<li><a href="/member/idsearch">아이디찾기</a></li>
			<li><a href="/member/login">로그인</a></li>
		</ul>
		<h1>board</h1>
		<ul>
			<li><a href="/board/notice">공지</a></li>
			<li><a href="/board/event">이벤트</a></li>
			<li><a href="/board/product">상품</a></li>
			<li><a href="/board/write">쓰기</a></li>
		</ul>
		
		<a href="https://kauth.kakao.com/oauth/logout?client_id=7980f70fd5da76a168557ced9cb2c60e&logout_redirect_uri=http://localhost:8000/kakao/logout&response_type=code">logout</a>
		
	</body>
</html>