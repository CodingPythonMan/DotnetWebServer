<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function insertPopup(){
	$("#no").val(0);
	// window.open(이름, 경로명, 크기("width,height"), )
	window.open("","pop","width=700, height=400");
	$("#popupForm").attr("action", "/subject/selectSubject.do");
	$("#popupForm").attr("target", "pop");
	$("#popupForm").submit();
}

function updatePopup(no){
	$("#no").val(no);
	// window.open(이름, 경로명, 크기("width,height"), )
	window.open("","pop","width=700, height=400");
	$("#popupForm").attr("action", "/subject/selectSubject.do"); 
	$("#popupForm").attr("target", "pop");
	$("#popupForm").submit();
}
</script>
<style type="text/css">
table{
	width: 570px;
}
caption{
	text-align: center;
	font-size: 17px;
	font-weight: bold;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div>
		<a href="../">메인</a>
	</div>
	<form id="popupForm" name="popupForm" method="post">
		<input type="hidden" name="no" id="no" />
	</form>
	<table border="1">
		<caption>학과</caption>
		<tr>
			<th width="120px">일련번호</th>
			<th width="100px">학과번호</th>
			<th width="220px">학과명</th>
			<th width="110px">상세보기</th>
		</tr>
		<c:forEach items="${subjectList }" var="row">
			<tr>
				<td align="center">${row.no }</td>
				<td align="center">${row.s_num }</td>
				<td align="center">${row.s_name }</td>
				<td align="center"><input type="button" value="[ 수정/삭제 ]" onclick="updatePopup('${row.no}')" /></td>
			</tr>		
		</c:forEach>
			
		<tr>
			<td colspan=3 align="center">학과정보등록</td>
			<td align="center"><input type="button" value="[ 학과 등록 ]" onclick="insertPopup()"/></td>
		</tr>
	</table>
	<p></p>
	<table border=1>
		<tr>
			<th align="center">학 과 명</th>
			<td colspan=2><input type="text" /></td>
			<td><input type="button" value="검색" /></td>
		</tr>
	</table>
</body>
</html>