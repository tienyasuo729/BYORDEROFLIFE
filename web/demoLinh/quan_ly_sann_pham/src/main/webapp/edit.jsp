<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<center>
    <h1>Edit product</h1>
    <h2>
        <a href="list?action=list">List product</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/list">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <tr>
                <th>NAME:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>PRICE:</th>
                <td>
                    <input type="number" name="price" size="45" >
                </td>
            </tr>
            <tr>
                <th>QUANTITY:</th>
                <td>
                    <input type="number" name="quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>COLOR:</th>
                <td>
                    <select multiple name="color">
                        <option value="red">red</option>
                        <option value="blue">blue</option>
                        <option value="Black">Black</option>
                        <option value="white">white</option>
                        <option value="yellow">yellow</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>DESCRIPTION:</th>
                <td>
                    <input type="text" name="description" size="15"/>
                </td>
            </tr>
            <tr>
                <th>CATEGORY:</th>
                <td>
                    <select name="category">
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}"><c:out value="${category.name}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="idEdit" value="${product}">
                    <input type="hidden" value="Edit" name="action2">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
