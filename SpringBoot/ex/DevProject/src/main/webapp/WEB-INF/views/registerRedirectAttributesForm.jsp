<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RedirectAttributes 데이터 전달 화면</title>
</head>
<body>
	<h2>RedirectAttributes 데이터 전달 화면</h2>

	<form action="/registerRedirectAttributes" method="post">
		userId: <input type="text" name="userId" value="hong" /><br>
		password: <input type="text" name="password" value="1234" /><br>
		<input type="submit" value="registerRedirectAttributes">
	</form>
</body>
</html>