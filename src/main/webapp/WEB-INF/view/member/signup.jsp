<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>회원가입</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <link rel="stylesheet" href="/resources/css/form.css">
    <style>
      .helper-text {
        font-size: 0.8rem;
        color: #9e9e9e;
        margin-top: 0.2rem;
        margin-bottom: 0.5rem;
      }
      .input-field{
        margin-bottom: 0.2rem;
      }
    </style>
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
            <div>
                <form:errors path="email" cssClass="helper-text"/>
                <span class="helper-text" id="idCheckMsg" style="display: none"></span>
            </div>
            <div class="input-field">
                <i class="material-icons prefix">lock</i>
                <form:input path="password" class="custom-input" placeholder="Password" type="password" />
            </div>
                <form:errors path="password" cssClass="helper-text"/>

            <div class="input-field">
                <i class="material-icons prefix">home</i>
                <form:input path="address" class="custom-input" placeholder="Address" />
            </div>
                <form:errors path="address" cssClass="helper-text"/>

            <div class="input-field">
                <i class="material-icons prefix">home</i>
                <form:input path="postNum" class="custom-input" placeholder="Postal Code" />
            </div>
                <form:errors path="postNum" cssClass="helper-text"/>

            <div style="margin-top: 2rem;">
                <button type="submit" class="btn custom-btn">회원가입</button>
            </div>
        </form:form>
    </div>

</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>

<script>
  const validElement = document.querySelector('#idCheckMsg');
  document.querySelector('#email').addEventListener('focusout', async ev => {
    const id = ev.target.value;
    if(!id) return;

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(id)) {
      validElement.style.display = 'block';
      validElement.textContent = '올바르지 않은 이메일 형식입니다.';
      return;
    }

    const response = await fetch('/api/member/exists/' + id);
    const data = await response.json();
    validElement.style.display = 'block';
    validElement.textContent = data.data ? '사용이 불가능한 이메일 입니다.' : '사용 가능한 이메일 입니다.';
  });

  document.querySelector('#signupRequest').addEventListener('submit', async ev => {
    // form tag 의 기본 이벤트 차단
    ev.preventDefault();

    const id = document.querySelector('#email').value;
    if(!id) return;
    const response = await fetch('/api/member/exists/' + id);
    const data = await response.json();

    if(data.data){
      document.querySelector('#email').focus();
      validElement.textContent = '사용이 불가능한 이메일 입니다.';
      return;
    }

    ev.target.submit();
  });
</script>
</html>
