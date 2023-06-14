<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 11/06/2023
  Time: 11:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello world</h1>
<form action="/hello/add" method="post">
    <label>id: <input type="text" name="id"></label><br>
    <label>name: <input type="text" name="name"></label><br>
    <button>save</button>
</form>
<h1>${showif}</h1>

</body>
</html>
