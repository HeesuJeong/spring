<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보드등록</h1>
	<form action="boardinsert" method="post" id="boardform">
		<!-- 값 안 주면 기본이 get -->
		<table border="1">
			<tr>
				<!-- 서버쪽에서 인자의 키로 넘어가는 name, 반드시 있어야 하는 값은 required로 -->
				<td>NUM</td>
				<td><input type="text" id="num" name="num" required="required"></td>
			</tr>
			<tr>
				<td>TITLE</td>
				<td><input type="text" id="title" name="title"
					required="required"></td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td><input type="text" id="content" name="content"
					required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화"><input
					type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>