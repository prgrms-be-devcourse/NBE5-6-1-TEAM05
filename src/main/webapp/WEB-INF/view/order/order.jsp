<%@include file="/WEB-INF/view/include/page.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang='ko'>
<head>

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
    <title>Title</title>
<%--    <%@ include file="/WEB-INF/view/include/static.jsp" %>--%>
</head>

<body>
<%--    <%@ include file="/WEB-INF/view/include/header.jsp" %>--%>
<%--    <%@include file="/WEB-INF/view/include/sidenav.jsp" %>--%>
<main class="container">

    <div class="row justify-content-center m-4">
        <h6 class="col text-center"><a class="btn title fs-1" href="http://localhost:8080/">Grids & Circle</a></h6>
    </div>
    <div class="card">
        <div class="row">
            <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
                <h5 class="flex-grow-0"><b>상품 목록</b></h5>
                <ul class="list-group products">


                    <c:if test="${not empty coffeeDtos}">
                        <c:forEach items="${coffeeDtos}" var="coffee">
                            <li class="list-group-item d-flex mt-3">
                                <div class="col">
                                    <div class="row"><c:out value="${coffee.coffeeName}"/></div>
                                </div>
                                <div class="col text-center price"><c:out value="${coffee.price}"/></div>
                                <div class="col text-end action">
                                    <a class="btn btn-small btn-outline-dark add-btn" href="" data-coffeeId="${coffee.coffeeId}">+</a>
                                </div>
                                <div class="col text-end action">
                                    <a class="btn btn-small btn-outline-dark sub-btn" href="" data-coffeeId="${coffee.coffeeId}">-</a>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>

                </ul>
            </div>
            <div class="col-md-4 summary p-4">
                <div>
                    <h5 class="m-0 p-0"><b>Summary</b></h5>
                </div>
                <hr>


                <div class="coffee-list">
                    <c:if test="${not empty coffeeCart.value}">
                        <c:forEach items="${coffeeCart}" var="entry">
                            <div class="coffee-li d-flex align-items-center" data-coffeeId="${entry.value.id}">
                                <div class="row">
                                <h6 class="coffee-name mb-0 me-2"><c:out value="${entry.value.name}"/></h6>
                                <span class="badge bg-dark coffee-count me-2" data-coffeeId="${entry.value.id}"><c:out value="${entry.value.count}"/></span>
                                </div>
                                <div class="col text-end action"><a class="btn btn-sm btn-outline-dark delete-btn" data-coffeeId="${entry.value.id}" href="">X</a></div>

                            </div>
                        </c:forEach>
                    </c:if>
                </div>

                <div class="row" id="coffeeCartListTemplate" style="display:none;">
                    <div class="coffee-li d-flex align-items-center" data-coffeeId="0">
                        <h6 class="coffee-name mb-0 me-2">커피이름</h6>
                        <span class="badge bg-dark coffee-count me-2" data-coffeeId="0">0</span>
                        <div class="col text-end action"><a class="btn btn-sm btn-outline-dark delete-btn" data-coffeeId="0" href="">X</a></div>
                    </div>
                </div>

                <div class="col"><a class="btn btn-dark" data-coffeeId="0" href="http://localhost:8080/order/payment">구매하기</a></div>

            </div>
        </div>
    </div>

</main>
</body>

<script src="${context}/assets/js/count.js" defer></script>


</html>
