<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>마이페이지</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>

    <style>
      body {
        background-color: #f9f7f4;
      }

      .search-box {
        display: flex;
        gap: 1rem;
        margin-bottom: 2rem;
      }
      .search-box input {
        padding: 0.5rem 1rem;
        border: 1px solid #ccc;
        border-radius: 8px;
        width: 300px;
      }
      .search-box button {
        padding: 0.5rem 1.2rem;
        background: black;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
      }

      .order-section-title {
        margin: 3rem 0 1rem 0;
        font-size: 1.5rem;
        font-weight: bold;
      }

      .order-card {
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        padding: 1rem;
      }

      .order-header {
        background-color: #ccc;
        border-radius: 8px;
        padding: 1rem;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-weight: bold;
      }

      .order-detail {
        padding: 1rem 0.5rem;
        display: flex;
        align-items: center;
        border-bottom: 1px solid #eee;
      }

      .order-detail img {
        width: 50px;
        height: 50px;
        margin-right: 1rem;
      }

      .order-cancel-btn {
        background-color: #000;
        color: white;
        border: none;
        padding: 0.5rem 1rem;
        border-radius: 6px;
        font-weight: bold;
        cursor: pointer;
      }

      .order-cancel-btn:hover {
        background-color: #555;
      }
    </style>

</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <!-- 이메일 검색창 -->
    <form action="/member/guest" method="get" class="search-box">
        <input type="email" name="email" placeholder="이메일을 입력하세요" required />
        <button type="submit">검색</button>
    </form>

    <!-- 주문 내역 제목 -->
    <div class="order-section-title">
        주문 내역
    </div>

    <!-- 주문 목록 -->
    <div class="order-card">
        <c:if test="${not empty orders}">
            <c:forEach var="order" items="${orders}">
                <!-- 주문 헤더 -->
                <div class="order-header">
                    <div>
                        주문 날짜: ${fn:substringBefore(order.orderTime, 'T')}<br>
                        주소: ${order.address}
                    </div>
                    <form action="/order/cancel/${order.orderId}" method="post" style="margin:0;">
                        <button type="submit" class="order-cancel-btn">주문 취소</button>
                    </form>
                </div>

                <!-- 상세 주문 목록 -->
                <c:forEach var="detail" items="${detailedOrders[order.orderId]}">
                    <div class="order-detail">
                        <img src="${detail.coffeeImage[0].uploadPath}" alt="상품 이미지">
                        <div style="flex:1;">${detail.coffeeName}</div>
                        <div>${detail.quantity}개</div>
                    </div>
                </c:forEach>
            </c:forEach>
        </c:if>
    </div>

</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
<script src="${context}/assets/js/mypage-delete.js" defer></script>

</html>
