<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<col width="25%">	
					<col width="25%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>취미</th>
				</tr>
		<c:forEach var="m" items="${mlist }">
			<tr>
				<td>${m.id } </td>
				<td>${m.name } </td>
				<td>${m.gender } </td>
				<td>${m.hobbys } </td>
			</tr>	
		</c:forEach>
				

			</table>
			<a href = ""><button type="button">홈으로</button></a>
		
		</div>
	</body>
</html>