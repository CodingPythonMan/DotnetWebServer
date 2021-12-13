<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 방식 요청 처리</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#registerBtn01").on("click", function(){	
	$.get("/register01/hong", function(result){
			console.log("result: " + result);
			if(result == "SUCCESS"){
				alert("SUCCESS");
			}
		});
	});
	
	$("#registerBtn02").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal};
		
		$.ajax({
			type:"post",
			url : "/register02/hong/pw01",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn03").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal};
		
		$.ajax({
			type:"post",
			url : "/register03",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn04").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal};
		
		$.ajax({
			type:"post",
			url : "/register04?userId=user01",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn05").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal};
		
		$.ajax({
			type:"post",
			url : "/register05/hong",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn06").on("click", function(){
		var userObjectArray = [
			{userId: "name01", password: "pw01"},
			{userId: "name02", password: "pw02"}];
		
		$.ajax({
			type:"post",
			url : "/register06",
			data :JSON.stringify(userObjectArray),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn07").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal, address : {postCode:"010908", location: "seoul"}};
		
		$.ajax({
			type:"post",
			url : "/register07",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
	
	$("#registerBtn08").on("click", function(){
		var userId = $("#userId");
		var password = $("#password");
		var userIdVal = userId.val();
		var passwordVal = password.val();
		
		var userObject = {userId : userIdVal, password : passwordVal, cardList:[{no:"23456", validMonth: "20190908"}, {no:"12342", validMonth: "20200705"}]};
		
		$.ajax({
			type:"post",
			url : "/register08",
			data :JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result: " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");	
				}
			}
		});
	});
});
</script>
</head>
<body>
	<h1>Ajax 방식 요청 처리</h1>
	<form>
		userId: <input type="text" name="userId" value="hong" id="userId"><br>
		password: <input type="text" name="password" value="1234" id="password"><br>
	</form>
	<button id="registerBtn01">registerBtn01</button>
	<button id="registerBtn02">registerBtn02</button>
	<button id="registerBtn03">registerBtn03</button>
	<button id="registerBtn04">registerBtn04</button>
	<button id="registerBtn05">registerBtn05</button>
	<button id="registerBtn06">registerBtn06</button>
	<button id="registerBtn07">registerBtn07</button>
	<button id="registerBtn08">registerBtn08</button>
</body>
</html>