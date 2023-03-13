<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .input {
            height:180px; width:230px;
            margin:0;
            padding:10px;
            border:1px #CCC solid;
        }
    </style>
</head>
<body>
<h1>Product Discount Calculator</h1>
<div class="input">
<label for="productDescription">Product Description: </label>
<input id="productDescription" type="text" name="productDescription" size="30"><br>
<label for="ListPrice">List Price: </label>
<input id="ListPrice" type="text" name="productDescription" size="30"><br>
<label for="DiscountPercent">Discount Percent: </label>
<input id="DiscountPercent" type="text" name="productDescription" size="30">
</div>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>