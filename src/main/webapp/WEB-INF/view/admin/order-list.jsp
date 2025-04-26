<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">

    <div class="row justify-content-center m-4">
        <h6 class="col text-center"><a class="btn title fs-1" href="http://localhost:8080/">Grids & Circle</a></h6>
    </div>
    <div class="card">
        <div class="row m-0">
            <div class="w-100">
                <h5 class="text-center"><b>주문 목록</b></h5>
                <ul class="list-group products collapsible" style="width:100%;">
                    <div class="list-group-item d-flex w-100">
                        <div class="col text-center"><c:out value="주문 번호"/></div>
                        <div class="col text-center"><c:out value="이메일"/></div>
                        <div class="col text-center"><c:out value="주소"/></div>
                        <div class="col text-center"><c:out value="우편번호"/></div>
                        <div class="col text-center"><c:out value="주문 시각"/></div>
                    </div>
                    <c:if test="${not empty orderMap}">
                        <c:forEach items="${orderMap}" var="entry">
                            <li>
                                <div class="list-group-item d-flex w-100">
                                    <div class="collapsible-header">
                                    <div class="col text-center"><c:out value="${entry.key.orderNum}"/></div>
                                    <div class="col text-center"><c:out value="${entry.key.email}"/></div>
                                    <div class="col text-center"><c:out value="${entry.key.address}"/></div>
                                    <div class="col text-center"><c:out value="${entry.key.postNum}"/></div>
                                    <div class="col text-center"><c:out value="${entry.key.orderTime}"/></div>

                                    <c:if test="${entry.key.isDelivered}">
                                        <div class="col text-center">배송 완료</div>
                                    </c:if>
                                    <c:if test="${entry.key.isDelivered==false}">
                                    <div class="col text-center">배송 전</div>
                                    </div>
                                    <div class="col text-end">
                                        <a class="btn btn-small btn-outline-dark delivery-btn" href="#" data-orderNum="${entry.key.orderNum}">배송 완료 처리</a>
                                    </div>
                                    <div class="col text-end">
                                        <a class="btn btn-small btn-outline-dark delete-btn" href="#" data-orderNum="${entry.key.orderNum}">주문 취소</a>
                                    </div>
                                </div>
                                </c:if>

                                <div class="collapsible-body">
                                    <div class="list-group-item d-flex w-100">
                                        <div class="col text-center">커피 아이디</div>
                                        <div class="col text-center">수량</div>
                                    </div>
                                    <c:forEach items="${entry.value}" var="datail">
                                        <div class="list-group-item d-flex w-100">
                                            <div class="col text-center"><c:out value="${datail.coffeeId}"/></div>
                                            <div class="col text-center"><c:out value="${datail.quantity}"/></div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>

</main>
<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
<script src="${context}/assets/js/manage-order.js" defer></script>
</html>
