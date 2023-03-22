<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 3/8/2023
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student list</title>
</head>
<body>
<h1>Student list</h1>
<a>Create new Student</a>
<table>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Giá</th>
        <th>Ghi chú</th>
        <th>NSX</th>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.price}</td>
            <td>${s.describe}</td>
            <td>${s.producer}</td>
<%--            <td><a href="/student?action=detail&id=${s.id}">Detail</a></td>--%>
<%--            <td><a href="/student?action=update&id=${s.id}">Detail</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
