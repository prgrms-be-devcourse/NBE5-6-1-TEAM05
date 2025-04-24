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
        <div class="card-panel red lighten-2 text-white">이메일이나 비밀번호를 확인하세요</div>
    </c:if>
    <form:form modelAttribute="signinRequest" class="col s12" action="/member/signin" method="post">
        <div class="row">
            <div class="input-field col s7 ">
                <i class="material-icons prefix">account_circle</i>
                <form:input path="email" id="email" name="email" type="text" placeholder="email"
                            class="validate"/>
                <form:errors path="email" cssClass="helper-text"/>
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">account_circle</i>
                <form:input path="password" id="password" name="password" type="password"
                            placeholder="password"
                            class="validate"/>
                <form:errors path="password" cssClass="helper-text"/>
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