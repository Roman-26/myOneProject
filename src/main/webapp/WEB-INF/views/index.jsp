<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Welcome</h1>
<sec:authorize access="isAnonymous()">
    <div>
        <a href="/login">Login</a>
    </div>
    <div>
        <a href="/register">Your registration</a>
    </div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="/profile">Profile</a>
</sec:authorize>
</body>
</html>
