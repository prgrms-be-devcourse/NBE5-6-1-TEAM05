<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>주문 상세</title>
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
        flex-direction: column;
        align-items: center;
        padding: 2rem;
      }
      .detail-box {
        width: 100%;
        max-width: 1100px;
        height: 700px;
        border: 2px solid black;
        border-radius: 16px;
        background: white;
        padding: 2rem;
        overflow-y: auto;
      }
      .order-info {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 1rem;
        font-size: 0.95rem;
      }
      .order-info div {
        width: 50%;
        margin-bottom: 0.5rem;
      }
      .order-table {
        flex: 1;
        border-top: 1px solid #333;
        margin: 1rem 0;
        padding-top: 1rem;
        text-align: center;
        color: #666;
      }
      .button-group {
        display: flex;
        justify-content: flex-end;
        gap: 1rem;
      }
      .button-group button {
        background: black;
        color: white;
        border: none;
        padding: 0.5rem 1rem;
        border-radius: 8px;
        cursor: pointer;
      }
      .page-title {
        font-size: 1.8rem;
        font-weight: bold;
        margin-bottom: 0.5rem;
        color: #333;
        text-align: left;
      }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="page-title">주문 상세</div>

    <div class="detail-box">
        <!-- 주문 정보 -->
        <div class="order-info">
            <div>주문번호: ${order.orderNum}</div>
            <div>주문시각: ${order.orderTime}</div>
            <div>이메일: ${order.email}</div>
            <div>배송 상태: <c:out value="${order.isDelivered ? '배송 완료' : '배송 전'}"/></div>
            <div style="width: 100%;">주소(우편번호): ${order.address} (${order.postNum})</div>
        </div>

        <!-- 커피 리스트 테이블 자리 -->
        <div class="order-table">
            <table style="width:100%; border-collapse: collapse; font-size: 0.95rem;">
                <thead>
                <tr>
                    <th style="border-bottom: 1px solid #ccc; padding: 0.5rem;">커피 ID</th>
                    <th style="border-bottom: 1px solid #ccc; padding: 0.5rem;">이름</th>
                    <th style="border-bottom: 1px solid #ccc; padding: 0.5rem;">수량</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requests}" var="item">
                    <tr>
                        <td style="padding: 0.5rem; border-bottom: 1px solid #eee;"><c:out value="${item.coffeeId}"/></td>
                        <td style="padding: 0.5rem; border-bottom: 1px solid #eee;"><c:out value="${item.coffeeName}"/></td>
                        <td style="padding: 0.5rem; border-bottom: 1px solid #eee;"><c:out value="${item.quantity}"/>개</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- 버튼 영역 -->
        <div class="button-group">
            <button class="delivery-btn" data-orderNum="${order.orderNum}">배송완료</button>
            <button class="delete-btn" data-orderNum="${order.orderNum}">주문 취소</button>
            <button onclick="history.back()">닫기</button>
        </div>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
<script src="${context}/assets/js/manage-order.js" defer></script>
</html>
