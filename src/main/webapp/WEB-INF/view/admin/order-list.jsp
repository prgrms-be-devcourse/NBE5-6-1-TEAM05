<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>주문 관리</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <style>
      body{
        background-color: #f9f7f4;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
      }

      main.container {
        flex: 1;
        padding: 2rem;
        display: flex;
        flex-direction: column;
        align-items: center;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        min-width: 900px;
      }

      .order-table-wrapper{
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        width: 100%;
        max-width: 1100px;
        flex: 1;
        overflow-y: auto;
        padding: 1rem;
        margin-top: 1rem;
        margin-bottom: 1rem;
        min-height: 400px;
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
        color: #333;
        align-self: flex-start;
      }

    </style>
</head>

<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">

    <div class="page-title">주문 관리</div>

    <div class="order-table-wrapper">
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
