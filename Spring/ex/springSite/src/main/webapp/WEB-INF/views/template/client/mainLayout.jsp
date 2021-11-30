<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/resources/images/common/icon.png">
<title><tiles:getAsString name="title" /></title>

<!-- Bootstrap core CSS -->
<link href="/resources/include/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/include/dist/css/sticky-footer-navbar.css" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>
	
	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<div class="jumbotron">
				<h1>노력은 배신하지 않는다.</h1>
				<p>Efforts are not betraying you...</p>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6 col-lg-4">
				<h2>게시판 관리</h2>
				<p>처음으로 만든 게시판, 이미지 첨부가 가능한 게시판.
				입력/수정/삭제 및 댓글 작성까지 처리 완료.</p>
				<p><a class="btn btn-default" href="/board/boardList.do" role="button">
				View details &raquo;</a></p> 
			</div>
			<div class="col-xs-6 col-lg-4">
				<h2>갤러리 게시판 관리</h2>
				<p>썸네일 처리 게시판. 입력 처리 완료. lightbox 처리.</p>
				<p><a class="btn btn-default" href="/gallery/galleryList.do" role="button">
				View details &raquo;</a></p>
			</div>
			<div class="col-xs-6 col-lg-4">
				<h2>로그인 및 회원 관리</h2>
				<p>회원 가입/정보 수정/회원 탈퇴 처리 완료.
				로그인 및 로그아웃 처리 완료</p>
				<p><a class="btn btn-default" href="/member/login.do" role="button">
				View details &raquo;</a></p>
			</div>
		</div>
	</div>
	
	<footer class="footer">
		<tiles:insertAttribute name="footer"/>
	</footer>
	
	<!-- Bootstrap core javaScript
	=============================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="/resources/include/dist/js/bootstrap.min.js"></script>
</body>
</html>