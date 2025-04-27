<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Grids & Circles</title>

    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>

<!-- ✨ 공통 header include -->
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<!-- ✨ 배너 영역 -->
<div class="banner">
    <img src="/resources/images/banner.jpg" alt="커피 배너" style="width: 100%; height: 300px; object-fit: cover;">
</div>

<main class="container center-align" style="margin-top: 2rem;">
    <h4>오늘의 추천 커피</h4>

    <div class="row" style="margin-top: 2rem;">
        <c:forEach var="coffee" items="${coffeeList}">
            <div class="col s12 m6 l4">
                <div class="card hoverable">
                    <div class="card-image" style="padding-top: 1rem;">
                        <img src="/resources/images/coffee-icon.png" alt="커피 아이콘" style="width: 50px; margin: auto;">
                    </div>
                    <div class="card-content">
                        <h5 class="black-text">${coffee.coffeeName}</h5>
                        <p class="grey-text">짧은 설명</p>
                        <p class="black-text" style="margin-top: 0.5rem;">€ ${coffee.price}</p>
                    </div>
                    <div class="card-action">
                        <a class="btn brown lighten-1 white-text" href="#">구매하기</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
