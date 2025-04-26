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
    <form:form action="${context}/admin/menu/update/${coffeeRegistRequest.coffeeId}" method="post" enctype="multipart/form-data" modelAttribute="coffeeRegistRequest">
        <input type="hidden" name="_method" value="PUT"/>
                <div class="row">
            <div class="btn">
                <span>File</span>
                <input type="file" name="thumbnail">
            </div>
            <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <form:textarea path="coffeeName" name="coffeeName" id="icon_prefix2" class="materialize-textarea" />
                <form:errors path="coffeeName" />
                <label for="icon_prefix2">name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <form:textarea path="price" name="price" id="icon_prefix3" class="materialize-textarea"/>
                <form:errors path="price" />
                <label for="icon_prefix3">price</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <form:textarea path="stock" name="stock" id="icon_prefix4" class="materialize-textarea"/>
                <form:errors path="stock" />
                <label for="icon_prefix4">stock</label>
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