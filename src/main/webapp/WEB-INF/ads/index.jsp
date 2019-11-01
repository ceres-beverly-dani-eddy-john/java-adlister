<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">



    <div class="page-header">
        <h1>Here Are all the ads!<small></small></h1>
    </div>

    <c:forEach var="ad" items="${ads}">
    <div class="row">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <h2><a href="/info?id=${ad.id}"> ${ad.title}</a></h2>
                <div class="caption">
                    <p>${ad.description}</p>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
</div>

</body>
</html>
