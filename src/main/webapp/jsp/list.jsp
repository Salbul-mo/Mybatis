<%--
  Created by IntelliJ IDEA.
  User: MO
  Date: 2024-11-29
  Time: 오전 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>회원 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
  .container {
    width: 40%;
  }
</style>
<body>
<div class="container d-flex flex-column justify-content-center text-center text-info">
    <fieldset>
        <h2 class="my-3">회원 리스트</h2>
        <table class="table mt-2">
            <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${!empty list}">
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.password}</td>
                        <td>
                            <button type="button" class="btn btn-sm btn-info" data-id="${item.id}">수정</button>
                        </td>
                        <td>
                            <c:if test="${item.id != 'admin'}">
                                <button type="button" class="btn btn-sm btn-danger" data-id="${item.id}">삭제</button>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty list}">
                <h2> 회원 목록을 불러오는데 실패했습니다</h2>
            </c:if>
            </tbody>
        </table>
        <div><a href="main.net">메인으로</a></div>
    </fieldset>
</div>
<script>
    $(".btn-info").click(function(){
      const id = $(this).attr("data-id");
      location.href = 'updateForm.net?id=' + id;
    });

    $(".btn-danger").click(function(){
      if (confirm("정말 삭제하시겠습니까?")) {
        const id = $(this).attr("data-id");
        location.href= "delete.net?id=" + id;
      }
    })
</script>
</body>
</html>
