<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 등록 창</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$("#insertData").click(function(){
		// form 태그 action으로 보낼 땐 모든 input 값이 채워져야한다.
		$("#no").val(0);
		$("#subjectForm").attr("action", "/subject/insertSubject.do");
		$("#subjectForm").submit();
	});
	
	$("#updateData").click(function(){
		$("#no").attr("disabled", false);
		$("#subjectForm").attr("action", "/subject/updateSubject.do");
		$("#subjectForm").submit();
	});
	
	$("#deleteData").click(function(){
		$("#subjectForm").attr("action", "/subject/deleteSubject.do");
		$("#subjectForm").submit();
	});
	
	$("#closeWindow").click(function(){
		window.close();
	});
});
</script>
</head>
<body>
	<form id="subjectForm" name="subjectForm" method="post">
		<table border=1>
			<caption>학과 테이블</caption>
			<tr>
				<th>일련번호</th>
				<td><input type="text" id="no" name="no" value="${svo.no }" disabled/></td>
			</tr>
			<tr>
				<th>학과번호</th>
				<td><input type="text" id="s_num" name="s_num" value="${svo.s_num }"/></td>
			</tr>
			<tr>
				<th>학과명</th>
				<td><input type="text" id="s_name" name="s_name" value="${svo.s_name }" /></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td><input type="button" id="insertData" value="등록" /></td>
			<td><input type="button" id="updateData" value="수정" /></td>
			<td><input type="button" id="deleteData" value="삭제" /></td>
			<td><input type="button" id="closeWindow" value="닫기" /></td>
		</tr>
	</table>
</body>
</html>