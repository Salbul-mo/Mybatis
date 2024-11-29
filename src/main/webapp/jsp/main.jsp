<%--
  Created by IntelliJ IDEA.
  User: MO
  Date: 2024-11-28
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>main.jsp</title>
    <style>
      body {
        text-align: center;
      }

      a {
        text-decoration: none;
      }

    </style>
</head>
<body>
<c:if test='${empty sessionScope.id}'>
    <script>
      location.href = "loginForm.net";
    </script>
</c:if>

<h2>로그인 되었습니다.</h2>
<a href="logout.net">로그아웃</a>
<hr>
<c:if test="${sessionScope.id == 'admin'}">
    <c:out value="관리자모드!"/><br>
    <a href="list.net">회원명단</a><br>
</c:if>

</body>
</html>
