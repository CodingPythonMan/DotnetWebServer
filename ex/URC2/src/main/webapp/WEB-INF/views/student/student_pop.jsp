<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 테이블 팝업</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		var mode = "${mode}";	
		if(mode == "insert"){
			$("#insertData").attr('disabled', false);
			$("#updateData").attr('disabled', true);
			$("#deleteData").attr('disabled', true);
		}else if(mode == "update"){
			$("#no").attr('readonly', true);
			$("#sd_id").attr('readonly', true);
			$("#sd_name").attr('readonly', true);
			$("#s_num").attr("readonly", true);
		
			$("#idCheck").attr('disabled', true);
			$("#insertData").attr('disabled', true);
			$("#updateData").attr('disabled', false);
			$("#deleteData").attr("disabled", false);
		}
		
		$("#insertData").click(function(){
			if(!validateForm()){
				return;
			}
			if($("#no").val() == ""){
				$("#no").val(0);
			}
			if(confirm('학생 정보 등록을 진행할까요?')){
				$("#studentForm").attr("action", "/student/insertStudent.do");
				$("#studentForm").submit();
			}
		});
		
		$("#updateData").click(function(){
			if(!validateForm()){
				return;
			}
			if(confirm("학생 정보 수정을 진행할까요?")){
				$("#studentForm").attr("action", "/student/updateStudent.do");
				$("#studentForm").submit();
			}
		});
		
		$("#deleteData").click(function(){
			if(confirm("학생 정보 삭제를 진행할까요?")){
				$("#studentForm").attr("action", "/student/deleteStudent.do");
				$("#studentForm").submit();
			}
		});
		
		$("#closeWindow").click(function(){
			window.close();
		});
		
		$("#s_num").click(function(){
			$.ajax({
				url : "/student/studentNum.do",
				type : "post"
				data : "s_num=" + $('select option:chekced').val(),
				error : function(){
					alert('시스템 오류입니다. 관리자에게 문의하세요.');
				},
				success : function(){
					$("#sd_num").val(resultData);
				}
			});
		});
		
		$("#idCheck").click(function(){
			if($("#sd_id").val().replace(/\s/g, "") == ""){
				alert("아이디를 입력해주세요.");
				return false;
			}else{
				$.ajax({
					url : "/student/idCheck.do",
					type : "post",
					data : "sd_id=" + $("#sd_id").val(),
					datatype : "text",
					success : function(resultData){
						if(resultData == "ok"){
							alert("사용할 수 없는 아이디입니다.");
							$("#sd_id").val("");
							$("#sd_id").focus();
						}else{
							alert("사용할 수 있는 아이디입니다.");
							$("#sd_id").attr("readOnly", "readOnly");
							$("#insertData").attr("disabled", false);
						}
					},
					error : function(){
						alert("시스템 오류입니다. 관리자에게 문의하세요.");
					}
				});
			}
		});
	});
	
	function validateForm(){
		if($("#sd_name").val().replace(/\s/g, "") == ""){
			alert("학생 이름을 입력해주세요.");
			return false;
		}
		if($("#sd_id").val().replace(/\s/g, "") == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if($("#sd_passwd").val().replace(/\s/g, "") == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if($("#sd_birthday").val().replace(/\s/g, "") == ""){
			alert("생년월일을 입력해주세요.");
			return false;
		}
		if($("#sd_phone").val().replace(/\s/g, "") == ""){
			alert("핸드폰번호를 입력해주세요.");
			return false;
		}
		if($("#sd_address").val().replace(/\s/g, "") == ""){
			alert("주소를 입력해주세요.");
			return false;
		}
		if($("#sd_email").val().replace(/\s/g, "") == ""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
.required{
	color: red;
}
table{
	width: 550px;
}
table th{
	width: 200px;
	text-align: left;
}
</style>
</head>
<body>
	<div>
		<form id="studentForm" name="studentForm" method="post">
			<table border="1">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h4>학생 테이블 팝업창 [Student]</h4>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><span class="required">*</span>학생일련번호</th>
						<td><input type="text" id="no" name="no" value="${StudentVO.no }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>학과번호</th>
							<td>
								<c:choose>
									<c:when test="${StudentVO.s_num == null }">
										<select id="s_num" name="s_num">
											<option>학과를 선택하세요</option>
											<c:forEach items="${subjectNum }" var="row">
												<option value="${row.s_num }">${row.s_num }:${row.s_name }</option>
											</c:forEach>
										</select>
									</c:when>
									<c:when test="${StudentVO.s_num != null }">
										<input type="text" id="s_num" name="s_num" value="${StudentVO.s_num }" />
									</c:when>
								</c:choose>
							</td>
					</tr>
					<tr>
						<th><span class="required">*</span>학생이름</th>
						<td><input type="text" id="sd_name" name="sd_name" value="${StudentVO.sd_name }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>아이디</th>
						<td><input type="text" id="sd_id" name="sd_id" value="${StudentVO.sd_id }" />
						<input type="button" value="중복체크" id="idCheck" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>비밀번호</th>
						<td><input type="password" id="sd_passwd" name="sd_passwd" value="${StudentVO.sd_passwd }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>생년월일</th>
						<td><input type="date" id="sd_birthday" name="sd_birthday" value="${StudentVO.sd_birthday }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>핸드폰번호(-제외)</th>
						<td><input type="tel" id="sd_phone" name="sd_phone" value="${StudentVO.sd_phone }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>주소</th>
						<td><input type="text" id="sd_address" name="sd_address" value="${StudentVO.sd_address }" /></td>
					</tr>
					<tr>
						<th><span class="required">*</span>이메일</th>
						<td><input type="email" id="sd_email" name="sd_email" value="${StudentVO.sd_email }" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div>
		<p></p>
		<table>
			<tr align="center">
				<td><input type="button" id="insertData" value="등록" /></td>
				<td><input type="button" id="updateData" value="수정" /></td>
				<td><input type="button" id="deleteData" value="삭제" /></td>
				<td><input type="button" id="closeWindow" value="닫기" /></td>
			</tr>
		</table>
	</div>
</body>
</html>