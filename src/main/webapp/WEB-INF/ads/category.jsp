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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h2>${category_name}</h2>

<c:forEach var="ad" items="${adscat}">
    <div class="col-md-6">
        <h1><a href="/info?id=${ad.id}"> ${ad.title}</a></h1>
        <p>${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
