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
    <form:form modelAttribute="signupRequest" class="col s12" action="/member/signup" method="post" id="signupRequest">
        <div class="row">
            <div class="input-field col s7 ">
                <i class="material-icons prefix">email</i>
                <form:input path="email" id="email" name="email" type="email" placeholder="email"
                            class="validate"/>
                <form:errors path="email" cssClass="helper-text"/>
                <span class="helper-text" id="emailCheckMsg" style="display: none"></span>
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">account_circle</i>
                <form:input path="password" id="password" name="password" type="password"
                            placeholder="password"
                            class="validate"/>
                <form:errors path="password" cssClass="helper-text"/>
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">house</i>
                <form:input path="address" id="address" name="address" type="text" placeholder="address"
                            class="validate"/>
                <form:errors path="address" cssClass="helper-text"/>
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">house</i>
                <form:input path="postNum" id="postNum" name="postNum" type="text" placeholder="postNumber"
                            class="validate"/>
                <form:errors path="postNum" cssClass="helper-text"/>
            </div>
        </div>
        <button class="btn waves-effect waves-light offset-s1" type="submit" name="action">
            Submit
            <i class="material-icons right">send</i>
        </button>
    </form:form>

</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

<script>
    const validElement = document.querySelector('#emailCheckMsg');
    document.querySelector('#email').addEventListener('focusout', async ev => {
        const email = ev.target.value;
        if(!email) return;
        const encodedEmail = encodeURIComponent(email);
        const response = await fetch('/api/member/exists/' + encodedEmail);
        const data = await response.json();
        validElement.style.display = 'block';
        validElement.textContent = data.data ? '사용이 불가능한 이메일 입니다.' : '사용 가능한 이메일 입니다.';
    });

    document.querySelector('#signupRequest').addEventListener('submit', async ev => {
      // form tag 의 기본 이벤트 차단
      ev.preventDefault();

      const email = document.querySelector('#email').value;
      if(!email) return;
      const response = await fetch('/api/member/exists/' + email);
      const data = await response.json();

      if(data.data){
        document.querySelector('#email').focus();
        validElement.textContent = '사용이 불가능한 이메일 입니다.';
        return;
      }

      ev.target.submit();
    });
</script>

</body>
</html>