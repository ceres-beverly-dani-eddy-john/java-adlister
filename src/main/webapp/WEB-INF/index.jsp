<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Adlister!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">

        <div class="jumbotron">
            <h1>Welcome to the Adlister!</h1>
            <p><a class="btn btn-primary btn-lg" href="/ads" role="button">View Ads!</a></p>
        </div>
        <c:forEach var="category" items="${categories}">
            <div class="col-md-6">
                <h2><a href="/category?category=${category.id}"> ${category.name}</a></h2>
            </div>
        </c:forEach>

    </div>
</body>
</html>
