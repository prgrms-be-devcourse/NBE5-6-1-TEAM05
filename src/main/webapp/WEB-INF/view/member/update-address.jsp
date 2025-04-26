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
    <form:form action="${context}/member/mypage/update" method="post" modelAttribute="updateAddressRequest">
        <div class="row">
            <div class="input-field col s7 ">
                <h4><c:out value="${email}님의 변경할 주소를 입력해주세요."/></h4>
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">house</i>
                <form:input path="address" id="address" name="address" type="text" placeholder="address"
                            class="validate"/>
                <form:errors path="address" cssClass="helper-text"/>
            </div>
        </div>
        <button class="btn waves-effect waves-light offset-s1" type="submit" name="action">
            Submit
            <i class="material-icons right">send</i>
        </button>
    </form:form>

</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>