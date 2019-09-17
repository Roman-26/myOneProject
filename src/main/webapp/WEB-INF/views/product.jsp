<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.08.2019
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product</h1>
<form:form action="/addProduct" method="post" modelAttribute="product">
    <div>
        <form:input path="name" placeholder="Name Product"/>
    </div>
    <div>
       <form:input path="price" placeholder="Price"/>
    </div>
    <div>
        <form:input path="amount" placeholder="Amount"/>
    </div>
    <div>
        <form:input path="manufacturer" placeholder="Manufacturer"/>
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
    <div>
        <a href="/profile">Back to Profile</a>
    </div>

</form:form>
</body>
</html>
