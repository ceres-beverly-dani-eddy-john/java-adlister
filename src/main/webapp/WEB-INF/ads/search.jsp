<%--
  Created by IntelliJ IDEA.
  User: eddybautista
  Date: 2019-10-30
  Time: 07:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Here are your results!</h1>

<div class="card-body">
    <a href="/ad/id/?${ad.id}">
        <h3 class="card-title">${ad.title}</h3>
    </a>
    <h5 class="text-left">Date: ${ad.date},  Ad ID:${ad.id}</h5>
    <p class="card-text">Description: ${ad.description}</p>
    <h4 class="text-right">Block: ${ad.block}</h4>
    <h4 class="text-right">Category: ${ad.category}</h4>
</div>

</body>
</html>
