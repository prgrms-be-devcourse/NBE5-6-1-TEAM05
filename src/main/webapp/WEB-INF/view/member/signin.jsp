<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>로그인</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <link rel="stylesheet" href="/resources/css/form.css">
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="form-container">
        <h4 style="font-weight: bold;">Login</h4>

        <c:if test="${not empty param.error}">
            <div class="card-panel red lighten-2 text-white" style="margin-bottom: 2rem;">이메일이나 비밀번호를 확인하세요</div>
        </c:if>

        <form:form modelAttribute="signinRequest" action="/member/signin" method="post">
            <div class="input-field">
                <i class="material-icons prefix">email</i>
                <form:input path="email" class="custom-input" placeholder="Email Address" />
            </div>

            <div class="input-field">
                <i class="material-icons prefix">lock</i>
                <form:input path="password" class="custom-input" placeholder="Password" type="password" />
            </div>

            <div class="row">
                <p>
                    <label>
                        <input type="checkbox" name="remember-me" />
                        <span>로그인 상태 유지</span>
                    </label>
                </p>
            </div>

            <div style="margin-top: 2rem;">
                <button type="submit" class="btn custom-btn">로그인</button>
            </div>
        </form:form>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
