<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>구매하기</title>
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
        width: 100%;
        padding: 0 2rem; /* 양옆 살짝만 띄우기 */
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
      }

      .order-layout {
        display: flex;
        width: 100%;
        max-width: 1600px; /* 화면이 커도 1600px까지만 */
        margin: 2rem auto;
        gap: 2rem;
        height: calc(100vh - 160px);
        padding: 0;
      }

      .product-list {
        flex: 2;
        background: white;
        padding: 2rem;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        overflow-y: auto;
      }

      .product-list h5 {
        font-weight: bold;
        margin-bottom: 2rem;
      }

      .product-item {
        display: flex;
        align-items: center;
        padding: 1rem 0;
        border-bottom: 1px solid #eee;
      }

      .product-item img {
        width: 80px;
        height: 80px;
        object-fit: cover;
        border-radius: 8px;
        margin-right: 1rem;
      }

      .product-info {
        flex: 1;
      }

      .product-name {
        font-weight: bold;
      }

      .product-price {
        margin-top: 0.3rem;
        color: #666;
      }

      .product-stock {
        margin-top: 0.3rem;
        color: #666;
      }

      .add-btn {
        padding: 0.5rem 1rem;
        border: 1px solid #333;
        background: none;
        border-radius: 8px;
        font-size: 0.9rem;
        cursor: pointer;
      }

      .cart-section {
        flex: 1;
        background: #e5e5e5;
        padding: 2rem;
        border-radius: 12px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 100%;
      }

      .cart-title {
        font-weight: bold;
        font-size: 1.2rem;
        text-align: center;
      }
      .divider {
        border: none;
        border-top: 1px solid #ccc;
        margin: 1rem 0;
      }

      .cart-section h5 {
        font-weight: bold;
        text-align: center;
        margin-bottom: 1.5rem;
      }

      .cart-item {
        display: flex;
        justify-content: space-between;
        margin-bottom: 1rem;
      }

      .badge {
        color: white;
        border-radius: 10px;
        padding: 0.2rem 0.5rem;
        font-size: 0.8rem;
        align-self: flex-start;
      }

      .purchase-btn {
        width: 100%;
        background-color: #333;
        color: white;
        font-weight: bold;
        border: none;
        padding: 1rem;
        border-radius: 8px;
        font-size: 1rem;
        cursor: pointer;
      }

      .delete-btn{
        align-self: flex-end;
      }

      .purchase-btn:hover {
        background-color: #555;
      }

      .cart-item-actions {
        display: flex;
        align-items: center;
        gap: 0.5rem;
      }

    </style>


</head>

<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="order-layout">
        <!-- 상품 목록 영역 -->
        <div class="product-list">
            <h5>상품 목록</h5>

            <c:forEach items="${coffeeDtos}" var="coffee">
                <div class="product-item">
                    <c:if test="${not empty coffee.images}">
                        <c:forEach items="${coffee.images}" var="image">
                            <c:if test="${image.type.name() == 'THUMBNAIL'}">
                                <img src="${image.url}" alt="커피 이미지">
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <div class="product-info">
                        <div class="product-name">${coffee.coffeeName}</div>
                        <div class="product-price">${coffee.price}원</div>
                        <c:if test="${coffee.stock>0}">
                            <div class="product-stock">${coffee.stock}개</div>
                        </c:if>
                        <c:if test="${coffee.stock<=0}">
                            <div class="product-stock">품절</div>
                        </c:if>
                    </div>
                    <c:if test="${coffee.stock>0}">
                        <button class="add-btn" data-coffeeId="${coffee.coffeeId}">추가</button>
                    </c:if>
                </div>
            </c:forEach>

        </div>

        <!-- 장바구니 영역 -->
        <div class="cart-section">
            <div>
                <div class="cart-title">장바구니</div>
                <hr class="divider">
                <div class="coffee-list">
                    <c:forEach items="${coffeeCart}" var="entry">
                        <div class="cart-item coffee-li" data-coffeeId="${entry.value.id}">
                            <span>${entry.value.name}</span>
                            <div>
                                <div class="cart-item-actions">
                                    <span class="badge coffee-count" data-coffeeId="${entry.value.id}">${entry.value.coffeeCount}</span>
                                    <button class="delete-btn" data-coffeeId="${entry.value.id}">X</button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div id="coffeeCartListTemplate" style="display:none;">
                <div class="cart-item coffee-li" data-coffeeId="0">
                    <span class="coffee-name">커피 이름</span>
                    <div class="cart-item-actions">
                        <span class="badge coffee-count" data-coffeeId="0">0</span>
                        <button class="delete-btn" data-coffeeId="0">X</button>
                    </div>

                </div>
            </div>


            <form:form modelAttribute="orderRequest" class="col s12" action="/order" method="post" id="orderRequest">
                <button class="purchase-btn">구매하기</button>
            </form:form>
        </div>

    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

<script src="${context}/assets/js/count.js" defer></script>

</body>
</html>
