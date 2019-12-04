<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function boardupdate() {
		//var no = rform.no.value;
		//var title = rform.title.value;
		//var content = rform.content.value;
		rform.action = "boardupdate";
		rform.submit();
	}
	
	function boarddelete() {
		//var no = rform.no.value;
		rform.action = "boarddelete";
		rform.submit();
	}
</script>

</head>
<body>
	<form id="rform" method="post">
		<label for="no">번호</label>
		<input type="text" name="no" id="no" value="${board.no }">
		<br />
		<label for="title">제목</label>
		<input type="text" name="title" id="title" value="${board.title }">
		<br />
		<label for="content">내용</label>
		<input type="text" name="content" id="content" value="${board.content }">
		<br />
		<input type="button" value="수정" onclick="boardupdate()">
		<input type="button" value="삭제" onclick="boarddelete()">
	</form>
</body>
</html>