<%--
  Created by IntelliJ IDEA.
  User: eddybautista
  Date: 2019-10-30
  Time: 07:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .wid{
            width: 20em;
        }
    </style>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="page-header">
    <h1>Here are your results!<small></small></h1>
</div>


<c:forEach var="ad" items="${ads}">

    <div class="panel panel-info wid">
        <div class="panel-heading">
            <h2 class="panel-title"><a href="/info?id=${ad.id}">${ad.title}</a> </h2>
        </div>
        <div class="panel-body">
            <p>${ad.description}</p>
        </div>
    </div>
    <div class="col-md-6">
    </div>
</c:forEach>

</body>
</html>
