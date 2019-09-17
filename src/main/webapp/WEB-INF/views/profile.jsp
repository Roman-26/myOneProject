<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style>
        table {
            color: #333;
            font-family: Helvetica, Arial, sans-serif;
            width: 640px;
            /* Table reset stuff */
            border-collapse: collapse;
            border-spacing: 0;
        }

        td, th {
            border: 0 none;
            height: 30px;
        }

        th {
            /* Gradient Background */
            background: linear-gradient(#333 0%, #444 100%);
            color: #FFF;
            font-weight: bold;
            height: 40px;
        }

        td {
            background: #FAFAFA;
            text-align: center;
        }

        /* Zebra Stripe Rows */

        tr:nth-child(even) td {
            background: #EEE;
        }

        tr:nth-child(odd) td {
            background: #FDFDFD;
        }

        /* First-child blank cells! */
        tr td:first-child, tr th:first-child {
            background: none;
            font-style: italic;
            font-weight: bold;
            font-size: 14px;
            text-align: right;
            padding-right: 10px;
            width: 80px;
        }

        /* Add border-radius to specific cells! */
        tr:first-child th:nth-child(2) {
            border-radius: 5px 0 0 0;
        }

        tr:first-child th:last-child {
            border-radius: 0 5px 0 0;
        }
    </style>
</head>
<body>
<h1>Welcome to your Profile,${username}</h1>
<div>
    <a href="/">Back to index</a>
</div>
<div>
    <a href="/product">Add new Product</a>
</div>
<div>
    <a href="/logout">
        <button>Logout</button>
    </a>
</div>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Manufacturer</th>
            <th>action</th>
            <th>photo</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td>${product.manufacturer}</td>
                <td>
                    <a href="/delete/${product.id}">Delete product</a>
                </td>
                <td>
                    <form method="post" action="/upload/${product.id}" enctype="multipart/form-data">
                        <label for="file">File: </label>
                        <input type="file" id="file" name="file">
                        <input type="submit" value="Upload">
                    </form>
                </td>
                <td>
                    <img src="${product.productPicture}" width="50px" height="50px">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<div c:if="${message}">
    <h2>${message}</h2>
</div>
</body>
</html>
