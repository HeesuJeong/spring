<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>보드 정보</h1>
	<form action="meminsert" method="post" id="memform"> <!-- 값 안 주면 기본이 get -->
		<table border="1">
			<tr>
				<!-- 서버쪽에서 인자의 키로 넘어가는 name, 반드시 있어야 하는 값은 required로 -->
				<td>ID</td>
				<td><input type="text" id="id" name="id" required="required" value="${mem.id }"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw"
					required="required" value="${mem.pw }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name"
					required="required" value="${mem.name }"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" id="email" name="email" value="${mem.email }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화"><input
					type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>