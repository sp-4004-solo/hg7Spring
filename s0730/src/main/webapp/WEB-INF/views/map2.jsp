<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>map1.jsp</title>
		
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bae7d2024f1cc57d3dd100b1150fc501&libraries=services"></script>
		<script src="/js/daum2.js"></script>
		<style type="text/css">
			*{margin:0; padding:0;}
			#map{border:3px solid black;}
			#header{width:100ox; height:80px; text-align :center; margin-top:50px;}
		</style>
	</head>
	<body>
		<div id="header">
			<h1>다음지도</h1>
			<input type="text" id="keyword">
			<button id="daumMapBtn">버튼</button>
		</div>
		<div id="map" style="width:100%; height:600px;"></div>

	</body>
</html>