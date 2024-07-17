<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  if문이나 for문을 사용할때 꼭 입력해야 한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mlist.jsp</title>
		<style>
			*{margin: 0; padding: 0; }
			div{width: 800px; margin: 30px auto; text-align:center;}
			h1{margin-bottom: 30px;}
			table, th, td{border: 1px solid black; border-collapse: collapse;
							font-size: 16px;}
			th{width: 200px; height: 40px;}
			td{width: 400px; height: 40px;}
			button{width: 150px; height: 40px; margin-top: 30px;}
		</style>
	</head>
	<body>
	
		<div>
			<h1> 회원 전체 리스트 </h1>
			<table>
				<colgroup>
					<col width="20%">	
					<col width="20">
					<col width="10%">
					<col width="30%">
					<col width="20%">
				</colgroup>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>취미</th>
					<th>가입일</th>
				</tr>
		<c:forEach var="m" items="${ list}">
			<tr>
				<td> ${m. id}</td>
				<td> ${m. name}</td>
				<td> ${m. gender} </td>
				<td> ${m. hobbys} </td>
				<td> ${m. phone} </td>
			</tr>	
		</c:forEach>

			</table>
			<a href = ""><button type="button">홈으로</button></a>
		
		</div>
	</body>
</html>