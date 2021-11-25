<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 테이블</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function passwordCheck(row_no){
		var passwd = "#passwd" + row_no;
		var btnPw = "#btnPw" + row_no;
		var update = "#update" + row_no;
		
		if($(passwd).val().replace(/\s/g, "") == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else{
			$.ajax({
				url : "/student/pwcheck.do",
				type : "post",
				data : "sd_passwd=" + $(passwd).val() + "&no=" + row_no,
				datatype : "text",
				success : function(resultData){
					var ok = resultData;
					if(ok == "1"){
						alert("비밀번호가 맞습니다.");
						$(passwd).val("");
						$(update).attr("disabled", false);
						$(passwd).attr("disabled", true);
						$(btnPw).attr("disabled", true);
					}else{
						alert("비밀번호가 틀립니다. 다시 입력하세요.");
						$(passwd).val("");
						$(passwd).focus();
					}
				},
				error : function(){
					alert("시스템 오류 입니다. 관리자에게 문의 하세요.");
				}
			});
		}
	}
	
	function insertPopup(){
		$("#no").val(0);
		window.open("", "pop", "width=900, height=700");
		$("#popupForm").attr("action","/student/selectStudent.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	
	function updatePopup(no){
		var passwd = "#passwd" + no;
		var btnPw = "#btnPw" + no;
		var update = "#update" + no;
		
		$(update).attr("disabled", true);
		$(passwd).attr("disabled", false);
		$(btnPw).attr("disabled", false);
		
		$("#no").val(no);
		window.open("", "pop", "width=900, height=700");
		$("#popupForm").attr("action", "/student/selectStudent.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	
	function listSearch(){
		location.reload();
	}
</script>
<style type="text/css">
table{
	width: 700px
}
td{
	text-align: center
}
#searchForm table th{
	width: 114px
}
#searchForm table td{
	width: 104px;
	text-align: center;
}
#sd_name{
	width: 310px
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
			<caption><h3>학생[Student]</h3></caption>
			<colgroup>
				<col width="120px" />
				<col width="110px" />
				<col width="110px" />
				<col width="360px" />
			</colgroup>
			<thead>
				<tr>
					<th>학생 일련번호</th>
					<th>학생 번호</th>
					<th>학생 이름</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty studentList }">
					<tr>
						<td colspan="5">등록된 학생 정보가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${studentList }" var="row">
					<tr>
						<td>${row.no }</td>
						<td>${row.sd_num }</td>
						<td>${row.sd_name }</td>
						<td><input type="button" id="update${row.no }" value="[ 수정/삭제 ]" disabled="disabled" onclick="updatePopup('${row.no }')" />
						<input type="button" id="btnPw${row.no }" value="확인" onclick="passwordCheck('${row.no}')" />
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">학생 정보 수정/삭제는 비밀번호 확인 후 가능</td>
					<td><input type="button" onclick="insertPopup()" value="[ 학생 정보 등록 ]" /></td>
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
					<th>학 생 명</th>
					<td><input type="text" id="sd_name" name="sd_name" /></td>
					<td><input type="button" onclick="listSearch()" value="검색" />
				</tr>
			</table>
		</form>
	</div>
</body>
</html>