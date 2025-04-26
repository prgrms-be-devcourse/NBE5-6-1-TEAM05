<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang='ko'>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <h4>email : <span><c:out value="${member.email}"/></span></h4>
    <h4>address : <span><c:out value="${member.address}"/></span></h4>
    <h4>postNum : <span><c:out value="${member.postNum}"/></span></h4>
    <div class="row justify-content-center m-4">
        <h6 class="col text-center"><a class="btn title fs-1" href="http://localhost:8080/member/mypage/update">주소 수정</a></h6>
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
                    <c:if test="${not empty orders}">
                        <c:forEach items="${orders}" var="order">
                            <li>
                                <div class="list-group-item d-flex w-100">
                                    <div class="collapsible-header">
                                        <div class="col text-center"><c:out value="${order.orderNum}"/></div>
                                        <div class="col text-center"><c:out value="${order.email}"/></div>
                                        <div class="col text-center"><c:out value="${order.address}"/></div>
                                        <div class="col text-center"><c:out value="${order.postNum}"/></div>
                                        <div class="col text-center"><c:out value="${order.orderTime}"/></div>

                                        <c:if test="${order.isDelivered}">
                                            <div class="col text-center">배송 완료</div>
                                        </c:if>
                                        <c:if test="${order.isDelivered==false}">
                                        <div class="col text-center">배송 전</div>
                                    </div>
                                    <div class="col text-end">
                                        <a class="btn btn-small btn-outline-dark delete-btn" href="#" data-orderNum="${order.orderNum}">주문 취소</a>
                                    </div>
                                </div>
                                </c:if>

                                <div class="collapsible-body">
                                    <div class="list-group-item d-flex w-100">
                                        <div class="col text-center">커피 아이디</div>
                                        <div class="col text-center">수량</div>
                                    </div>
                                    <c:forEach items="${detailedOrders}" var="datail">
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
</html>
