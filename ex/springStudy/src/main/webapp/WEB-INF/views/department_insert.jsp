<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 테이블</title>
<style type="text/css">
.required{
	color: red;
}
</style>
</head>
<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td colspan="2" align="center">
						<h4>학과 테이블에 입력된 데이터입니다.</h4>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="100">
						<span class="required">*</span>학과코드</th>
					<td width="300">${dvo.deptid }</td>
				</tr>
				<tr>
					<th><span class="required">*</span>학과명</th>
					<td>${dvo.deptname }</td>
				</tr>				
				<tr>
					<th><span class="required">*</span>전화번호</th>
					<td>${dvo.depttel }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>