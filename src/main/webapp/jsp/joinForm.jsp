<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
	<style>
		.container {
			margin:3em auto;
			box-shadow:3px 3px 30px gray;
			width:500px;
		}

		.cancel {
			background-color:red;
		}
	</style>
	<script>
		$(function(){
			$('.join').click(function(){
				location.href = "joinForm.net";
			});

			const result = '${message}';
			if (result != '') {
				alert(result);
				<%session.removeAttribute("message");%>
			}

			const id = '${cookieId}';
			if (id) {
				$("#id").val(id).css('font-weight','bold');
				$("#remember").prop('checked', true);
			}
		})
	</script>
</head>
<body>
<form name="loginProcess" action="joinPro.net" method="post">
	<h1>회원가입</h1>
	<hr>
	<b>아이디</b>
	<input type="text" id="id" name="id" placeholder="Enter id" required>
	<b>Password</b>
	<input type="password" name="password" id="pass" placeholder="Enter password" required>
	<div class="clearfix">
		<button type="submit" class="submitbtn">회원가입</button>
		<button type="reset" class="cancel">취소</button>
	</div>
</form>
</body>
</html>