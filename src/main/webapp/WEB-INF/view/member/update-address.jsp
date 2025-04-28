<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>주소 변경</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>

    <style>
      body {
        background-color: #f9f7f4;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
      }

      main.container {
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
        padding: 2rem;
        margin: 0 auto;
      }

      .title {
        font-size: 4rem;
        font-weight: bold;
        margin-bottom: 2rem;
        text-align: left;
        color: #333;
      }

      .form-wrapper {
        display: flex;
        gap: 1rem;
        align-items: center;
      }

      .address-input {
        width: 1000px;
        height: 2.8rem;
        padding: 0.5rem;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 1rem;
      }
      .postNum-input {
        width: 150px;
        height: 2.8rem;
        padding: 0.5rem;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 1rem;
      }

      .submit-btn {
        width: 150px;
        height: 2.8rem;
        background-color: black;
        color: white;
        font-weight: bold;
        border: none;
        padding: 0 1.5rem;
        border-radius: 8px;
        font-size: 1rem;
        cursor: pointer;
      }

      .submit-btn:hover {
        background-color: #444;
      }
    </style>

</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="title">어디로 배송해드릴까요?</div>

    <form action="${context}/member/mypage/update" method="post" class="form-wrapper">
        <div>
            <label>
                <input type="text" name="postNum" placeholder="우편번호" class="postNum-input" required/>
            </label>
        </div>
        <input type="text" name="address" placeholder="주소" class="address-input" required/>
        <button type="submit" class="submit-btn">변경</button>
    </form>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>
