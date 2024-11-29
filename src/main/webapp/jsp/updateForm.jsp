<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
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

      .clearfix{
        display: flex;

      }

      h1 {
      text-align: center;
      }

      button {
        width: 100px;
        margin-left: 20px;
        margin-right: 20px;
        display: inline-block;
      }

      .submitbtn {
        background-color: #1ca0b8;
      }

      .cancel {
        background-color: #ffbf0b;
      }

      input[name='id'] {
        background-color: #b4b4b4;
      }

      input[name='id']:focus {
        background-color: #b4b4b4;
      }
    </style>
</head>
<body>
<form name="updateProcess" action="updatePro.net" method="post">
    <h1>회원 정보 수정</h1>
    <hr>
    <b>아이디</b>
    <input type="text" id="id" name="id" value="${member.id}" required readOnly>
    <b>Password</b>
    <input type="text" name="password" id="pass" value="${member.password}" required>
    <div class="clearfix">
        <button type="submit" class="submitbtn">변경</button>
        <button type="button" class="cancel" onclick="history.go(-1)">취소</button>
    </div>
</form>
</body>
</html>