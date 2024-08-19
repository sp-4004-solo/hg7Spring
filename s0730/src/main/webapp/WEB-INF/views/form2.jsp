<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form2.jsp</title>
	</head>
	<body>
		<h2>게시글 등록</h2>
		<form action="doform2" method="post" enctype="multipart/form-data" >
			<label>제목</label>
			<input type="text" name="btitle" />
			<br>
			<label>파일1</label>
			<input type="file" name="files" />
			<br>
			<label>파일2</label>
			<input type="file" name="files" />
			<br>
			<label>파일3</label>
			<input type="file" name="files" />
			<br>
			<input type="submit" name="저장" />
			<br>
		</form>
	</body>
</html>