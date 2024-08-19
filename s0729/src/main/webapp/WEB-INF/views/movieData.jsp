<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bikeData.jsp</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		#main{width: 1600px; margin: 20px auto; text-align: center}
		#body{width: 1600px; height: 1000px; margin: 20px auto;
		      border: 3px solid black;}
		table{width: 1400px; margin: 0 auto; }
		table, th, td{ border: 1px solid black; border-collapse: collapse;}
		th{height:40px;}
		td{height: 35px;}
		</style>
	</head>
	<body>



<!--  영화키-->
<!-- b3f40bfc34462b15dabef6f5b8d6c813 -->	



<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			//alert("클릭");
			$.ajax({
				url:"/searchMovie",
				type:"get",
				data:{"txt":$("#txt").val()},
				dataType:"json",
				success:function(data){
					alert("성공");
					console.log(data);
					
				},
				error:function(){
					alert("실패");
				}
				
			})//ajax	
		});//btn
	});//jquery
</script>
		<div id="main">
			<h1>영화 데이터 정보</h1>
			날짜 입력<input type="text" id="txt" name="txt">
			<button type="button" id="btn">검색</button>
			<br><br>
			<div id = "body">
				<table>
					<colgroup>
						<col width="10%">
						<col width="25%">
						<col width="10%">
						<col width="15%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>movieCd</th>
							<th>movieNm</th>
							<th>openDt</th>
							<th>salesShare</th>
							<th>salesChange</th>
							<th>scrnCnt</th>
						</tr>
					</thead>
					<tbody id="content">
					</tbody>
				</table>
			</div>
		
		</div>
	
	</body>
</html>

