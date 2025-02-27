<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
</head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
        <c:if test="${param.error==1}">
            <h2>Error - Please make sure "Title" and "Description" are not blank.</h2>
        </c:if>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            Categories
            <br>
            <input type="checkbox" value="Services" id="services" name="categories">
            <label for="services">
                Services
            </label>
            <br>
            <input type="checkbox" value="Housing" id="housing" name="categories">
            <label for="housing">
                Housing
            </label>
            <br>
            <input type="checkbox" value="For Sale" id="for-sale" name="categories">
            <label for="for-sale">
                For Sale
            </label>
            <br>
            <input type="checkbox" value="Jobs" id="jobs" name="categories">
            <label for="jobs">
                Jobs
            </label>
            <br>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
