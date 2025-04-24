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
        <h1 class="text-center">Grids & Circle</h1>
    </div>
    <div class="card">
        <div class="row">
            <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
                <h5 class="flex-grow-0"><b>상품 목록</b></h5>
                <ul class="list-group products">


<%--                    <c:if test="${not empty coffeeDtos}">--%>
<%--                        <c:forEach items="${coffeeDtos}" var="coffee">--%>
<%--                            <li class="list-group-item d-flex mt-3">--%>
<%--                                <div class="col">--%>
<%--                                    <div class="row"><c:out value="${coffee.name}"/></div>--%>
<%--                                </div>--%>
<%--                                <div class="col text-center price"><c:out value="${coffee.price}"/></div>--%>
<%--                                <div class="col text-end action">--%>
<%--                                    <a class="btn btn-small btn-outline-dark add-btn" href="" data-coffee-id="${coffee.coffeeId}">+</a>--%>
<%--                                </div>--%>
<%--                                <div class="col text-end action">--%>
<%--                                    <a class="btn btn-small btn-outline-dark sub-btn" href="" data-coffee-id="${coffee.coffeeId}">-</a>--%>
<%--                                </div>--%>
<%--                            </li>--%>
<%--                        </c:forEach>--%>
<%--                    </c:if>--%>


                    <li class="list-group-item d-flex mt-3">
                        <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg" alt=""></div>
                        <div class="col">
                            <div class="row text-muted">커피콩</div>
                            <div class="row">Columbia Nariñó</div>
                        </div>
                        <div class="col text-center price">5000원</div>
                        <div class="col text-end action"><a class="btn btn-small btn-outline-dark add-btn" href="" data-coffeeId="1">+</a></div>
                        <div class="col text-end action"><a class="btn btn-small btn-outline-dark sub-btn" href="" data-coffeeId="1">-</a></div>
                    </li>
                </ul>
            </div>
            <div class="col-md-4 summary p-4">
                <div>
                    <h5 class="m-0 p-0"><b>Summary</b></h5>
                </div>
                <hr>

                <div class="row">
                    <h6 class="p-0">Columbia Nariñó <span class="badge bg-dark text- coffee-count" data-coffeeId="1">2개</span></h6>
                    <div class="col text-end action"><a class="btn btn-small btn-outline-dark delete-btn" data-coffeeId="1" href="">X</a></div>
                </div>

<%--                세션에서 받아온 값 넣기 --%>


<%--                <!-- 생성될 영역 -->--%>
<%--                <div class="coffee-list">--%>
<%--                    <c:if test="${not empty coffeeDtos}">--%>
<%--                        <c:forEach items="${coffeeCart}" var="entry">--%>
<%--                                <div class="row">--%>
<%--                                    <h6 class="p-0">${entry.value.name} <span class="badge bg-dark coffee-count" data-coffeeId="${entry.value.id}"><c:out value="${entry.value.count}"></c:out></span></h6>--%>
<%--                                    <div class="col text-end action"><a class="btn btn-small btn-outline-dark delete-btn" data-coffeeId="${entry.value.id}" href="">X</a></div>--%>
<%--                                </div>--%>
<%--                        </c:forEach>--%>
<%--                    </c:if>--%>
<%--                </div>--%>

<%--                <div class="row" id="coffeeCartListTemplate" style="display:none;">--%>
<%--                    <h6 class="p-0 coffee-name">  <span class="badge bg-dark coffee-count" data-coffeeId="0"></span></h6>--%>
<%--                    <div class="col text-end action"><a class="btn btn-small btn-outline-dark delete-btn" data-coffeeId="0" href="">X</a></div>--%>
<%--                </div>--%>


                <form:form modelAttribute="orderRequest" class="col s12" action="/order" method="post" id="signupForm">
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
                        <h5 class="col text-end">15000원</h5>
                    </div>
                    <button class="btn btn-dark col-12" type="submit" name="action">결제하기</button>
                </form:form>
            </div>
        </div>
    </div>

</main>
</body>

<script src="${context}/assets/js/order.js" defer defer></script>

</html>
