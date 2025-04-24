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
    <h4>email : <span<c:out value="${member.email}"/>></span></h4>
    <h4>address : <span<c:out value="${member.address}"/>></span></h4>
    <h4>postNum : <span<c:out value="${member.postNum}"/>></span></h4>
</main>
<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>
