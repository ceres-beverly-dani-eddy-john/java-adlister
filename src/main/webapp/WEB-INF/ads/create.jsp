<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="form-group">
                <input type="checkbox" value="community" id="community" name="categories">
                <label for="community">
                    Community
                </label>
                <br>
                <input type="checkbox" value="services" id="services" name="categories">
                <label for="services">
                    Services
                </label>
                <br>
                <input type="checkbox" value="housing" id="housing" name="categories">
                <label for="housing">
                    Housing
                </label>
                <br>
                <input type="checkbox" value="for-sale" id="for-sale" name="categories">
                <label for="for-sale">
                    For Sale
                </label>
                <br>
                <input type="checkbox" value="jobs" id="jobs" name="categories">
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
