<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>Title</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <style>
      body {
        background: #ddd;
      }

      .card {
        margin: auto;
        max-width: 950px;
        width: 90%;
        box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 1rem;
        border: transparent
      }

      .summary {
        background-color: #ddd;
        border-top-right-radius: 1rem;
        border-bottom-right-radius: 1rem;
        padding: 4vh;
        color: rgb(65, 65, 65)
      }

      @media (max-width: 767px) {
        .summary {
          border-top-right-radius: unset;
          border-bottom-left-radius: 1rem
        }
      }

      .row {
        margin: 0
      }

      .title b {
        font-size: 1.5rem
      }

      .col-2,
      .col {
        padding: 0 1vh
      }

      img {
        width: 3.5rem
      }

      hr {
        margin-top: 1.25rem
      }
      .products {
        width: 100%;
      }
      .products .price, .products .action {
        line-height: 38px;
      }
      .products .action {
        line-height: 38px;
      }

    </style>

</head>
<body>

<main class="container">

    <div class="row justify-content-center m-4">
        <h6 class="col text-center"><a class="btn title fs-1" href="http://localhost:8080/">Grids & Circle</a></h6>
    </div>
    <div class="card">
        <div class="p-3 pt-4">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h5 class="mb-0"><b>주문 목록</b></h5>
                <a class="btn btn-outline-dark add-btn" href="http://localhost:8080/admin/menu/regist">메뉴 추가</a>
            </div>

            <ul class="list-group products">
                <c:if test="${not empty coffeeDtos}">
                    <c:forEach items="${coffeeDtos}" var="coffee">
                        <li class="list-group-item d-flex mt-3">
                            <div class="col">
                                <div class="row"><c:out value="${coffee.coffeeName}"/></div>
                            </div>
                            <div class="col text-center price"><c:out value="${coffee.price}"/></div>
                            <div class="col text-center price"><c:out value="${coffee.stock}"/></div>
                            <div class="col text-end action">
                                <a class="btn btn-small btn-outline-dark update-btn" href="http://localhost:8080/admin/menu/update/${coffee.coffeeId}">수정</a>
                            </div>
                            <div class="col text-end action">
                                <a class="btn btn-small btn-outline-dark delete-btn" href="" data-coffeeId="${coffee.coffeeId}">삭제</a>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>

</main>
</body>

<script src="${context}/assets/js/menu-btn.js" defer></script>
</html>
