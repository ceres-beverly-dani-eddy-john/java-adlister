<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
</head>
<body>



<%--form has to be dynamic for prefill --%>

<div class="container">
    <h1>Edit your ad</h1>

    <form action="/edit" method="post">
        <%--        <form action="https://request-inspector.glitch.me/" method="post">--%>
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${description}</textarea>
        </div>
<%--        Categories--%>
<%--        <br>--%>
<%--        <div class="form-group">--%>
<%--            <input type="checkbox" value="Community" id="community" name="categories">--%>
<%--            <label for="community">--%>
<%--                Community--%>
<%--            </label>--%>
<%--            <br>--%>
<%--            <input type="checkbox" value="Services" id="services" name="categories">--%>
<%--            <label for="services">--%>
<%--                Services--%>
<%--            </label>--%>
<%--            <br>--%>
<%--            <input type="checkbox" value="Housing" id="housing" name="categories">--%>
<%--            <label for="housing">--%>
<%--                Housing--%>
<%--            </label>--%>
<%--            <br>--%>
<%--            <input type="checkbox" value="For Sale" id="for-sale" name="categories">--%>
<%--            <label for="for-sale">--%>
<%--                For Sale--%>
<%--            </label>--%>
<%--            <br>--%>
<%--            <input type="checkbox" value="Jobs" id="jobs" name="categories">--%>
<%--            <label for="jobs">--%>
<%--                Jobs--%>
<%--            </label>--%>
<%--            <br>--%>
<%--        </div>--%>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

</body>
</html>
