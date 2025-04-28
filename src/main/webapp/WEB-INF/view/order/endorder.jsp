<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>주문 완료</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>

    <style>
      body {
        background-color: #f9f7f4;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
      }

      main.container {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        text-align: center;
        padding: 2rem;
      }

      .order-complete-title {
        font-size: 2rem;
        font-weight: bold;
        margin-bottom: 1rem;
        color: #333;
      }

      .order-complete-subtitle {
        font-size: 1rem;
        color: #666;
        margin-bottom: 3rem;
      }

      .button-group {
        display: flex;
        gap: 1rem;
      }

      .btn-black {
        background-color: #000;
        color: #fff;
        border: none;
        padding: 0.8rem 1.5rem;
        font-size: 1rem;
        font-weight: bold;
        border-radius: 8px;
        cursor: pointer;
        text-decoration: none;
      }

      .btn-black:hover {
        background-color: #333;
      }
    </style>
</head>

<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="order-complete-title">주문이 완료되었습니다.</div>
    <div class="order-complete-subtitle">감사합니다</div>
    <div class="button-group">
        <a href="/" class="btn-black">홈으로 돌아가기</a>
        <sec:authorize access="hasRole('USER')">
            <a href="/member/mypage" class="btn-black">주문 내역 확인하기</a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <a href="/member/guest" class="btn-black">주문 내역 확인하기</a>
        </sec:authorize>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
