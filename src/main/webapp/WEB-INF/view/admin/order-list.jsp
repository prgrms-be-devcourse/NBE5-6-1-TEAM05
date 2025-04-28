<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>주문 관리</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <style>
      .order-box {
        width: 100%;
        max-width: 1100px;
        height: 700px;
        border: 2px solid black;
        border-radius: 16px;
        background: white;
        padding: 2rem;
        overflow-y: auto;
      }

      .order-content {
        width: 100%;
      }

      .list-header, .list-row {
        display: flex;
        padding: 0.8rem 0;
        border-bottom: 1px solid #eee;
        font-size: 0.95rem;
      }

      .list-header {
        font-weight: bold;
        border-bottom: 2px solid #ccc;
      }

      .list-row:hover {
        background: #f9f9f9;
        cursor: pointer;
      }

      .col {
        flex: 1;
        text-align: center;
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
    <div class="page-title">주문 관리</div>

    <div class="order-box">
        <div style="width: 95%;">
            <!-- 헤더 -->
            <div class="list-header" style="display: flex; border-bottom: 1px solid #ccc; padding: 0.5rem 0; font-weight: bold;">
                <div class="col text-center" style="flex:1;">주문 번호</div>
                <div class="col text-center" style="flex:1;">이메일</div>
                <div class="col text-center" style="flex:2;">주소</div>
                <div class="col text-center" style="flex:1;">우편번호</div>
                <div class="col text-center" style="flex:1;">주문 시각</div>
                <div class="col text-center" style="flex:1;">배송 상태</div>
            </div>

            <!-- 주문 목록 -->
            <c:if test="${not empty orderDtos}">
                <c:forEach items="${orderDtos}" var="order">
                    <div class="list-row"
                         style="display: flex; padding: 0.5rem 0; border-bottom: 1px solid #eee; cursor: pointer;"
                         onclick="location.href='/admin/order/detail/${order.orderNum}'">
                        <div class="col text-center" style="flex:1;"><c:out value="${order.orderNum}"/></div>
                        <div class="col text-center" style="flex:1;"><c:out value="${order.email}"/></div>
                        <div class="col text-center" style="flex:2;"><c:out value="${order.address}"/></div>
                        <div class="col text-center" style="flex:1;"><c:out value="${order.postNum}"/></div>
                        <div class="col text-center" style="flex:1;"><c:out value="${order.orderTime}"/></div>
                        <div class="col text-center" style="flex:1;">
                            <c:choose>
                                <c:when test="${order.isDelivered}">
                                    배송 완료
                                </c:when>
                                <c:otherwise>
                                    배송 전
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>
