<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html lang="ko">
<head>
    <title>상품 추가</title>
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
        align-items: center;
        padding: 2rem;
      }

      .main-inner {
        width: 100%;
        max-width: 900px;
        display: flex;
        flex-direction: column;
        align-items: stretch;
      }

      .page-title {
        font-size: 1.8rem;
        font-weight: bold;
        margin-bottom: 2rem;
        color: #333;
        text-align: left;
      }

      .form-wrapper {
        display: flex;
        justify-content: space-between;
        gap: 2rem;
        margin-bottom: 2rem;
      }

      .image-upload {
        flex: 1;
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        padding: 2rem;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-between;
      }

      .image-upload img {
        width: 150px;
        height: 150px;
        object-fit: cover;
        border-radius: 8px;
        margin-bottom: 1rem;
      }

      .file-btn {
        height: 2.8rem;
        margin-top: 0.5rem;
        background-color: white;
        color: #333;
        border: 1px solid #333;
        padding: 0.5rem 1rem;
        border-radius: 8px;
        font-size: 1rem;
        cursor: pointer;
        font-weight: bold;
      }

      .file-btn:hover {
        background-color: #f0f0f0;
      }

      .file-name {
        margin-top: 0.5rem;
        font-size: 0.9rem;
        color: #555;
        text-align: center;
        word-break: break-all;
      }

      .input-area {
        flex: 2;
        background: white;
        border: 1px solid #ccc;
        border-radius: 12px;
        padding: 2rem;
        display: flex;
        flex-direction: column;
        gap: 1.5rem;
      }

      .input-group {
        display: flex;
        align-items: center;
        gap: 1rem;
      }

      .input-group i {
        font-size: 1.5rem;
        color: #666;
      }

      .input-group input {
        flex: 1;
        padding: 0.8rem;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 1rem;
      }

      .submit-btn {
        height: 3rem;
        width: 100%;
        background-color: #333;
        color: white;
        font-weight: bold;
        border: none;
        padding: 1rem;
        border-radius: 8px;
        font-size: 1rem;
        cursor: pointer;
      }

      .submit-btn:hover {
        background-color: #555;
      }
    </style>

</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <div class="main-inner">
        <div class="page-title">상품 정보 수정</div>

        <form:form action="${context}/admin/menu/update/${coffeeRegistRequest.coffeeId}" method="post" enctype="multipart/form-data" modelAttribute="coffeeRegistRequest" id="coffeeRegistRequest" class="form-wrapper">

            <!-- 이미지 업로드 영역 -->
            <div class="image-upload">
                <c:if test="${empty image}">
                    <img src="#" alt="상품 이미지" id="preview">
                </c:if>
                <c:if test="${not empty image}">
                    <img src="${image.url}" alt="상품 이미지" id="preview">
                </c:if>
                <div class="file-name" id="fileName">선택된 파일 없음</div>
                <label class="file-btn">
                    파일 선택
                    <input type="file" name="thumbnail" id="thumbnail" accept="image/*" onchange="previewImage(event)" style="display: none;">
                </label>
            </div>

            <!-- 입력 폼 영역 -->
            <div class="input-area">
                <div class="input-group">
                    <i class="material-icons">mode_edit</i>
                    <form:input path="coffeeName" name="coffeeName" placeholder="상품 이름 입력" />
                </div>
                <form:errors path="coffeeName" cssClass="helper-text"/>

                <div class="input-group">
                    <i class="material-icons">mode_edit</i>
                    <form:input path="price" placeholder="가격 입력" />
                </div>
                <form:errors path="price" name="price" cssClass="helper-text"/>

                <div class="input-group">
                    <i class="material-icons">mode_edit</i>
                    <form:input path="stock" name="stock" placeholder="재고 입력" />
                </div>
                <form:errors path="stock" cssClass="helper-text"/>
                <!-- 하단 버튼 -->
                <button type="submit" class="submit-btn" form="coffeeRegistRequest">상품 수정</button>
            </div>


        </form:form>


    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

<!-- 이미지 미리보기 & 파일 이름 표시 스크립트 -->
<script>
  function previewImage(event) {
    const reader = new FileReader();
    reader.onload = function(){
      const output = document.getElementById('preview');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);

    const fileName = document.getElementById('fileName');
    fileName.innerText = event.target.files[0].name;
  }
  function previewImage(event) {
    const file = event.target.files[0];
    const preview = document.getElementById('preview');
    const fileNameDiv = document.getElementById('fileName');

    if (file) {
      const reader = new FileReader();
      reader.onload = function(e) {
        preview.src = e.target.result;
      };
      reader.readAsDataURL(file);

      fileNameDiv.textContent = file.name;
    } else {
      preview.src = '${image.url}';
      fileNameDiv.textContent = '선택된 파일 없음';
    }
  }
</script>



</body>
</html>
