<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
<c:if test="${not empty param.error}">
    <div class="card-panel red lighten-2 text-white">${param.error}</div>
</c:if>
<h4>Index</h4>
    <a href="/order">상품 주문하기</a>
</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>