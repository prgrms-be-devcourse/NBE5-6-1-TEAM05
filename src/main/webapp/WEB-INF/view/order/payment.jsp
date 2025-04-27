<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>결제하기</title>
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

      .page-title {
        text-align: center;
        font-size: 2.3rem;
        font-weight: bold;
        margin-top: 2rem;
        margin-bottom: 3rem;
        color: #333;
      }

      main.container {
        flex: 1;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
      }

      .payment-card {
        background: white;
        padding: 2rem;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 500px;
      }

      .payment-form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
      }

      .payment-form input {
        width: 100%;
        padding: 0.8rem;
        border: 1px solid #ddd;
        border-radius: 8px;
        font-size: 1rem;
      }

      .info-text {
        margin-top: 1rem;
        font-size: 0.9rem;
        color: #555;
      }

      .total-price {
        display: flex;
        justify-content: space-between;
        margin-top: 1.5rem;
        font-weight: bold;
        font-size: 1.2rem;
      }

      .pay-btn {
        width: 100%;
        margin-top: 1rem;
        padding: 1rem;
        border: none;
        border-radius: 8px;
        background-color: #333;
        color: white;
        font-size: 1rem;
        font-weight: bold;
        cursor: pointer;
      }

      .pay-btn:hover {
        background-color: #555;
      }
    </style>
</head>

<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="page-title">
        배송정보를 입력해주세요
    </div>

    <div class="payment-card">
        <form:form modelAttribute="orderRequest" action="/order/payment" method="post" id="orderRequest" class="payment-form">

            <form:input path="email" id="email" name="email" type="email" placeholder="이메일" class="validate" />
            <form:errors path="email" cssClass="helper-text"/>

            <form:input path="address" id="address" name="address" type="text" placeholder="주소" class="validate" />
            <form:errors path="address" cssClass="helper-text"/>

            <form:input path="postNum" id="postNum" name="postNum" type="text" placeholder="우편번호" class="validate" />
            <form:errors path="postNum" cssClass="helper-text"/>

            <div class="info-text">당일 오후 2시 이후 주문은 다음날 배송을 시작합니다.</div>

            <div class="total-price">
                <span>총금액</span>
                <span><c:out value="${total}"/>원</span>
            </div>

            <button type="submit" class="pay-btn">결제하기</button>

        </form:form>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
