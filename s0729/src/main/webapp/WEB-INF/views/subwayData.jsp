<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sportsData.jsp</title>
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




<script type="text/javascript">

//지하철 데이터 인증키		
//4f4d646659737075363850544d466b	
		
		$(function(){
		$("#btn").click(function(){
			//alert("클릭");
			$.ajax({
				url:"/searchSubway",
				type:"get",
				data:{"txt":$("#txt").val()},
				dataType:"json",
				success:function(data){
					alert("성공");
					console.log(data);
					var iarr = data.realtimeArrivalList;
					var str='';
					for(var i=0; i<iarr.length; i++){
						str += '<tr>';
						str += '<td>'+iarr[i].rowNum+'</td>';
						str += '<td>'+iarr[i].selectedCount+'</td>';
						str += '<td>'+iarr[i].totalCount+'</td>';
						str += '<td>'+iarr[i].subwayId+'</td>';
						str += '<td>'+iarr[i].updnLine+'</td>'; 
						str += '</tr>'; 
						
					}
					$("#content").html(str);
				},
				error:function(){
					alert("실패");
				}
				
			})//ajax	
		});//btn
	});//jquery
</script>
		<div id="main">
			<h1>지하철 데이터 정보</h1>
			역이름 입력<input type="text" id="txt" name="txt">
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
							<th>GUBUN</th>
							<th>SVCID</th>
							<th>MAXCLASSNM</th>
							<th>MINCLASSNM</th>
							<th>SVCSTATNM</th>
						</tr>
					</thead>
					<tbody id="content">
					</tbody>
				</table>
			</div>
		
		</div>
	
	</body>
</html>





















