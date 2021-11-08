<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 입력 화면</title>
<style type="text/css">
div{
	font: 12px "굴림";
}
</style>
</head>
<body>
	<div align="center" class="body">
		<h3>로그인 입력 화면</h3>
		<%-- 스프링 4.x --%>
		<%-- <form:form commandName="userVO" method="POST"> --%>
		<%-- 스프링 5.x --%>
		<form:form modelAttribute="userVO" method="POST">
			<table width="250" border="1">
				<tr>
					<th>아이디</th>
					<td><form:input path="m_uid" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><form:password path="m_pwd" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>