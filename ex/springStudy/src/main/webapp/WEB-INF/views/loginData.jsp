<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h3>로그인 입력 데이터</h3>
		<table width="250" border="1">
			<tr>
				<td>아이디 :</td>
				<td align="center"><b>${userVO.m_uid }</b></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td align="center"><b>${userVO.m_pwd }</b></td>
			</tr>
		</table>
	</div>
</body>
</html>