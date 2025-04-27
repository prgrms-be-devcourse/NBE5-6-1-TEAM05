<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>회원가입</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <link rel="stylesheet" href="/resources/css/form.css">
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="form-container">
        <h4 style="font-weight: bold; text-align: center; margin-bottom: 0;">Sign Up</h4>
        <p style="text-align: center; color: #666; margin-top: 0.5rem;">Create a new account</p>

        <form:form modelAttribute="signupRequest" action="/member/signup" method="post" id="signupRequest">
            <div class="input-field">
                <i class="material-icons prefix">email</i>
                <form:input path="email" class="custom-input" placeholder="Email Address" />
            </div>

            <div class="input-field">
                <i class="material-icons prefix">lock</i>
                <form:input path="password" class="custom-input" placeholder="Password" type="password" />
            </div>

            <div class="input-field">
                <i class="material-icons prefix">home</i>
                <form:input path="address" class="custom-input" placeholder="Address" />
            </div>

            <div class="input-field">
                <i class="material-icons prefix">home</i>
                <form:input path="postNum" class="custom-input" placeholder="Postal Code" />
            </div>

            <div style="margin-top: 2rem;">
                <button type="submit" class="btn custom-btn">회원가입</button>
            </div>
        </form:form>
    </div>

</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
