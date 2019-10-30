<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/ads/create">Create Post</a></li>
                </c:when>
            </c:choose>
            <form action="/search" method="get" class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" name="searchTerm" placeholder="Search" value="${param.searched}">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <li><a href="/login">Login</a></li>
                <li><a href="/register">Register</a></li>
                </c:when>
            </c:choose>
            <c:choose>
            <c:when test="${sessionScope.user != null}">
                <li><a href="/logout">Logout</a></li>
            </c:when>
        </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>