<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- ✨ Materialize Navbar -->
<nav class="white z-depth-1">
    <div class="nav-wrapper container">
        <a href="/" class="brand-logo black-text" style="font-weight: bold;">Grids & Circles</a>
        <ul class="right hide-on-med-and-down">

            <!-- ✨ 비로그인 사용자 -->
            <sec:authorize access="isAnonymous()">
                <li><a href="/" class="black-text">홈</a></li>
                <li><a href="/order" class="black-text">구매하기</a></li>
                <li><a href="/member/signup" class="black-text">회원가입</a></li>
                <li><a href="/member/signin"
                       class="btn-flat waves-effect black-text"
                       style="border: 1px solid black; border-radius: 8px; padding: 0 1.5rem;">로그인</a></li>
            </sec:authorize>

            <!-- ✨ 로그인한 일반 사용자 -->
            <sec:authorize access="hasRole('USER')">
                <li><a href="/" class="black-text">메인</a></li>
                <li><a href="/order" class="black-text">상품 목록</a></li>
                <li><a href="/member/mypage" class="black-text">마이페이지</a></li>
                <li><a href="#" id="logout" class="btn waves-effect waves-light brown lighten-1 white-text" style="margin-left: 1rem;">로그아웃</a></li>
            </sec:authorize>

            <!-- ✨ 로그인한 관리자 -->
            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/" class="black-text">메인</a></li>
                <li><a href="/order" class="black-text">상품 목록</a></li>
                <li><a href="/admin" class="black-text">관리자페이지</a></li>
                <li><a href="#" id="logout" class="btn waves-effect waves-light brown lighten-1 white-text" style="margin-left: 1rem;">로그아웃</a></li>
            </sec:authorize>

        </ul>
    </div>
</nav>

<!-- ✨ 로그아웃 폼 -->
<form:form action="/logout" method="post" id="logoutForm">
</form:form>

<!-- ✨ 로그아웃 스크립트 -->
<script>
  (() => {
    const logout = document.querySelector('#logout');
    if (!logout) return;

    logout.addEventListener('click', ev => {
      ev.preventDefault();
      document.getElementById('logoutForm').submit();
    });
  })();
</script>
