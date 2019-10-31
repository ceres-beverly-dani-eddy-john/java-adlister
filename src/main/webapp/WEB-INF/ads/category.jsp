<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eddybautista
  Date: 2019-10-31
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<%--<c: for--%>
<%--<h1>  <c:out value="${ads.title}"/></h1>--%>
<%--<p> <c:out value="${ads.description}"/></p>--%>


<c:forEach var="ad" items="${ads}">
    <div class="col-md-6">
        <h1><a href="/info?id=${ad.id}"> ${ad.title}</a></h1>
        <p>${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
