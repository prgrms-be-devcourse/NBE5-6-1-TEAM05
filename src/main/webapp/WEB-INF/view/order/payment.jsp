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

                <form:form modelAttribute="orderRequest" class="col s12" action="/order/payment" method="post" id="orderRequest">
                    <div class="mb-3">
                        <form:input path="email" id="email" name="email" type="email" placeholder="email"
                                    class="validate"/>
                        <form:errors path="email" cssClass="helper-text"/>
                    </div>
                    <div class="mb-3">
                        <form:input path="address" id="address" name="address" type="text" placeholder="address"
                                    class="validate"/>
                        <form:errors path="address" cssClass="helper-text"/>
                    </div>
                    <div class="mb-3">
                        <form:input path="postNum" id="postNum" name="postNum" type="text" placeholder="postNum"
                                    class="validate"/>
                        <form:errors path="postNum" cssClass="helper-text"/>
                    </div>
                    <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>
                    <div class="row pt-2 pb-2 border-top">
                        <h5 class="col">총금액</h5>
                        <h5 class="col text-end total"><c:out value="${total}"/>원</h5>
                    </div>
                    <button class="btn btn-dark col-12" type="submit" name="action">결제하기</button>
                </form:form>
            </div>
</main>
</body>

<script src="${context}/assets/js/count.js" defer></script>


</html>
