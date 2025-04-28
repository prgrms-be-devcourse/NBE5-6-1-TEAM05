<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>관리자 페이지</title>
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
        padding: 2rem;
        max-width: 1200px;
        margin: 0 auto;
      }

      .section {
        margin-bottom: 4rem;
      }

      .section-title {
        font-size: 1.5rem;
        font-weight: bold;
        margin-bottom: 1rem;
        display: flex;
        align-items: center;
      }

      .small-link {
        font-size: 0.9rem;
        color: #555;
        margin-left: 1rem;
        text-decoration: underline;
      }

      .status-box {
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        display: flex;
        justify-content: space-around;
        padding: 1.5rem 0;
      }

      .status-item {
        text-align: center;
        flex: 1;
        font-weight: bold;
        font-size: 1rem;
      }

      .divider-vertical {
        border-left: 1px solid #ccc;
        height: 100%;
      }

      .manage-btn {
        margin-top: 1rem;
        width: 100%;
        background: #333;
        color: white;
        padding: 1rem;
        border: none;
        border-radius: 8px;
        font-size: 1rem;
        font-weight: bold;
        cursor: pointer;
      }

      .manage-btn:hover {
        background: #555;
      }

      .menu-table-wrapper {
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        padding: 1rem;
        overflow-x: auto;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      th, td {
        padding: 1rem;
        text-align: center;
        border-bottom: 1px solid #eee;
      }

      th {
        background: #f5f5f5;
        font-weight: bold;
      }

      .big-num{
        font-size: 2rem;
        font-weight: bold;
        margin-top: 0.5rem;
      }

    </style>
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">

    <!-- 주문 현황 -->
    <div class="section">
        <div class="section-title">주문 현황</div>
        <div class="status-box">
            <div class="status-item">일일 주문수 <div class="big-num">${todayOrder}</div></div>
            <div class="divider-vertical"></div>
            <div class="status-item">대기중인 주문 <div class="big-num">${undeliveredOrder}</div></div>
            <div class="divider-vertical"></div>
            <div class="status-item">완료된 주문 <div class="big-num">${deliveredOrder}</div></div>
        </div>
        <button class="manage-btn" onclick="location.href='/admin/order/list'">주문 관리 페이지로 이동</button>
    </div>

    <!-- 메뉴 관리 -->
    <div class="section">
        <div class="section-title">
            상품 관리
            <a href="/admin/menu/list" class="small-link">상품 관리로 이동</a>
        </div>

        <div class="menu-table-wrapper">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>재고</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coffeeDtos}" var="coffee">
                    <tr>
                        <td>${coffee.coffeeId}</td>
                        <td>${coffee.coffeeName}</td>
                        <td>${coffee.price}원</td>
                        <td>${coffee.stock}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
