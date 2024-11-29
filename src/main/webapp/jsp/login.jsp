<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/views/common/headerImport.jsp"/>
<link href="../../../assets/css/indexCarousel.css" rel="stylesheet">
<link href="../../../assets/css/testimonial.css" rel="stylesheet">
<style>
  #wrapper {
    height: auto;
    min-height: 100%;
    padding-bottom: 300px;
  }

  .form-container {
    width: 600px;
    max-width: 90%;
    margin: 0 auto;
  }

  button[type="submit"] {
    background-color: orange;
  }

  button[type="submit"]:hover {
    cursor: pointer;
    background-color: lightgray;
  }
</style>
<head>
    <title>로그인</title>
</head>
<body data-spy="scroll" data-target=".fixed-top">
<main>
    <div id="wrapper">
    <div class="container">
        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                        <div class="d-flex justify-content-center py-4">
                            <a href="../index.jsp" class="logo d-flex align-items-center w-auto">
                                <span class="d-none d-lg-block">CODECRAFT에 오신 것을 환영합니다.</span>
                            </a>
                        </div>

                        <div class="card mb-3">

                            <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">로그인</h5>
                                    <p class="text-center small">이메일과 비밀번호를 입력해주세요.</p>
                                </div>

                                <div class="form-container">
                                    <form class="row g-3 needs-validation" novalidate
                                          action="${pageContext.request.contextPath}/members/loginProcess"
                                          method="post">
                                        <input type="hidden" name="uri" value="${param.uri}">

                                        <%-- EMAIL INPUT --%>
                                        <div class="col-12">
                                            <label for="email" class="form-label">이메일</label>
                                            <div class="input-group has-validation">
                                                <span class="input-group-text" id="inputGroupPrepend">@</span>
                                                <input type="email" name="email" class="form-control" id="email"
                                                       value="${email != null ? email : ''}" required>
                                                <div class="invalid-feedback">이메일을 입력해주세요.</div>
                                            </div>
                                        </div>

                                        <%-- PASSWORD INPUT --%>
                                        <div class="col-12">
                                            <label for="password" class="form-label">비밀번호</label>
                                            <input type="password" name="password" class="form-control" id="password"
                                                   required>
                                            <div class="invalid-feedback">비밀번호를 입력해주세요.</div>
                                        </div>

                                        <div class="col-12">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" name="remember"
                                                       value="true"
                                                       id="rememberMe" ${email != null ? 'checked' : ''}>
                                                <label class="form-check-label" for="rememberMe">내 정보 기억하기</label>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button class="btn btn-primary w-100" type="submit">로그인</button>
                                        </div>
                                    </form>
                                </div>

                                <div class="col-12 mt-3">
                                    계정이 없으신가요?&nbsp;&nbsp;&nbsp;
                                    <a href="signup">회원가입하기</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </section>
    </div>
    </div>
</main>

<!-- Footer -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<jsp:include page="/WEB-INF/views/common/footerImport.jsp"/>
</body>
</html>
