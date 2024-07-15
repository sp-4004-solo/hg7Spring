<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:if문사용하기 위해서 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- function 사용하기 위해서 --> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mForm</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="" method="post" name="frm">
		<label>아이디</label>
		<input type="text" name="id" id="id" value= "${member.id }"><br>
		<label>비밀번호</label>
		<input type="text" name="pw" id="pw" value="${member.pw }" ><br>
		<label>이름</label>
		<input type="text" name="name" id="name" value= "${member.name }"><br>
		
		<label>성별</label><br>
		
		<input type="radio" name="gender" id="male" value="male" 
		<c:if test="${member.gender == 'male' }">checked</c:if> >
		<label for="male">남성</label>
		
		
		
		<input type="radio" name="gender" id="female" value="female" 
		<c:if test="${member.gender == 'female' }">checked </c:if> >
		<label for="female">여성</label><br>
		
		<select name="job">
			<option value="worker" <c:if test="${member.job == 'worker'}"> selected </c:if> >회사원</option>
			<option value="self" <c:if test="${member.job == 'self'}"> selected </c:if> >자영업자</option>
			<option value="freelancer" <c:if test="${member.job == 'freelancer'}"> selected </c:if> >프리랜서</option>
			<option value="housewife" <c:if test="${member.job == 'housewife'}"> selected </c:if> >전업주부</option>
		</select>
		<label>취미</label><br>
		<input type="checkbox" name="hobbys" id="game" value="game" 
		<c:if test="${fn:contains(member.hobby,'game')}"> checked</c:if>>
		<label for="game">게임</label>
		
		<input type="checkbox" name="hobbys" id="golf" value="golf"
		 <c:if test="${fn:contains(member.hobby,'golf')}"> checked</c:if>>
		<label for="golf">골프</label>
		
		<input type="checkbox" name="hobbys" id="run" value="run"
		 <c:if test="${fn:contains(member.hobby,'run')}"> checked</c:if>>
		<label for="run">달리기</label>
		
		<input type="checkbox" name="hobbys" id="book" value="book"
		 <c:if test="${fn:contains(member.hobby,'book')}"> checked</c:if>>
		<label for="book">독서</label>
		
		<input type="checkbox" name="hobbys" id="swim" value="swim"
		 <c:if test="${fn:contains(member.hobby,'swim')}"> checked</c:if>>
		<label for="swim">수영</label>
		<br><br>
		
		<input type="submit" value="전송"><br>
		</form>
	</body>
</html>