<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 테이블</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function insertPopup(){
		$("#no").val(0);
		window.open("", "pop", "width=480, height=250");
		$("#popupForm").attr("action","/lesson/selectLesson.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	
	function updatePopup(no){
		$("#no").val(no);
		window.open("", "pop", "width=480, height=250");
		$("#popupForm").attr("action", "/lesson/selectLesson.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	
	function listSearch(){
		$("#searchForm").attr("action", "/lesson/listLesson.do");
		$("#searchForm").submit();
	}
</script>
<style type="text/css">
table{
	width: 570px
}
#searchForm table th{
	width: 114px
}
#searchForm table td{
	width: 104px;
	text-align: center;
}
#l_name{
	width: 328px
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
	<div>
		<table border="1">
			<caption><h3>과목[Lesson]</h3></caption>
			<colgroup>
				<col width="120px" />
				<col width="100px" />
				<col width="180px" />
				<col width="150px" />
			</colgroup>
			<thead>
				<tr>
					<th>과목 일련번호</th>
					<th>과목코드</th>
					<th>과목명</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty lessonList }">
					<tr>
						<td colspan="5" align="center">등록된 과목 데이터가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${lessonList }" var="row">
					<tr align="center">
						<td>${row.no }</td>
						<td>${row.l_abbre }</td>
						<td>${row.l_name }</td>
						<td><input type="button" value="[ 과목 수정/삭제 ]" onclick="updatePopup(${row.no });" />
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" align="center">과목 정보 등록</td>
					<td align="center"><input type="button" onclick="insertPopup()" value="[ 과목 등록 ]" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<p></p>
	<div>
		<!-- search -->
		<form id="searchForm" name="searchForm" method="post">
			<table border="1" cellpadding="1" cellspacing="1">
				<tr>
					<th width="100px">과 목 명</th>
					<td><input type="text" id="l_name" name="l_name" /></td>
					<td><input type="button" onclick="listSearch()" value="검색" />
				</tr>
			</table>
		</form>
	</div>
</body>
</html>