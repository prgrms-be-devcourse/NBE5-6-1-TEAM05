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

      .profile-box {
        width: 100%;
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        padding: 2rem;
        display: flex;
        align-items: center;
        gap: 2rem;
      }

      .profile-image {
        width: 120px;
        height: 120px;
        background-color: #eee;
        display: flex;
        align-items: center;
        justify-content: center;
        border-radius: 12px;
        font-size: 0.9rem;
        color: #888;
      }

      .profile-info {
        flex: 1;
      }

      .title-section {
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

      .delete-btn {
        background-color: #000;
        color: white;
        border: none;
        padding: 0.5rem 1rem;
        border-radius: 6px;
        font-weight: bold;
        cursor: pointer;
      }

      .delete-btn:hover {
        background-color: #555;
      }
    </style>

</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="title-section">
        내 정보
    </div>

    <!-- 프로필 영역 -->
    <div class="profile-box">
        <div class="profile-image">
            고객사진<br>(기능 미구현)
        </div>
        <div class="profile-info">
            <div style="font-size: 1.2rem; font-weight: bold;">
                ${member.email}
            </div>
            <div>[${member.postNum}] ${member.address}</div>
            <div style="margin-top: 0.5rem;">
                <a href="/member/mypage/update" style="font-size: 0.9rem;">주소 수정</a>
            </div>
        </div>
    </div>

    <!-- 주문 내역 제목 -->
    <div class="title-section">
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
                        <button type="submit" class="delete-btn" data-orderNum="${order.orderId}">주문 취소</button>

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
