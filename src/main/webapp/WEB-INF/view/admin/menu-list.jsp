<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>전체 상품 목록</title>
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
        padding: 2rem;
        display: flex;
        flex-direction: column;
        align-items: center;
      }

      .page-title {
        font-size: 1.8rem;
        font-weight: bold;
        color: #333;
        align-self: flex-start;
      }

      .product-table-wrapper {
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

      table {
        width: 100%;
        border-collapse: collapse;
        min-width: 900px;
      }

      th, td {
        padding: 1rem;
        text-align: center;
        border-bottom: 1px solid #eee;
      }

      th {
        background-color: #f4f4f4;
        font-weight: bold;
      }

      .product-img {
        width: 50px;
        height: 50px;
        object-fit: cover;
        border-radius: 8px;
      }

      .action-btn {
        padding: 0.6rem 1rem;
        background-color: #333;
        color: white;
        font-weight: bold;
        border: none;
        border-radius: 8px;
        font-size: 0.9rem;
        cursor: pointer;
      }

      .action-btn:hover {
        background-color: #555;
      }

      .add-btn {
        background-color: #333;
        color: white;
        font-weight: bold;
        border: none;
        padding: 1rem 2rem;
        border-radius: 8px;
        font-size: 1rem;
        text-align: center;
        cursor: pointer;
        margin-top: 1rem;
        width: 100%;
        max-width: 1100px;
      }

      .add-btn:hover {
        background-color: #555;
      }

    </style>
</head>

<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">

    <div class="page-title">전체 상품 목록</div>

    <div class="product-table-wrapper">
        <table>
            <thead>
            <tr>
                <th>사진</th>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
                <th>재고</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${coffeeDtos}" var="coffee">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${not empty coffee.images}">
                                <c:forEach items="${coffee.images}" var="image">
                                    <c:if test="${image.type.name() == 'THUMBNAIL'}">
                                        <img src="${image.url}" alt="커피 이미지" class="product-img" />
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==" alt="이미지 없음" class="product-img" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${coffee.coffeeId}" /></td>
                    <td><c:out value="${coffee.coffeeName}" /></td>
                    <td><c:out value="${coffee.price}" />원</td>
                    <td><c:out value="${coffee.stock}" />개</td>
                    <td>
                        <a href="/admin/menu/update/${coffee.coffeeId}" class="action-btn">수정</a>
                    </td>
                    <td>
                        <a href="#" class="action-btn delete-btn" data-coffeeId="${coffee.coffeeId}">삭제</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="/admin/menu/regist" class="add-btn">상품 추가</a>

</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

<script src="${context}/assets/js/menu-btn.js" defer></script>

</body>
</html>
