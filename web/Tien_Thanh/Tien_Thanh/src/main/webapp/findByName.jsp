<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 05/04/2023
  Time: 4:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>màu sắc</th>
            <th>Mô tả</th>
            <th>Danh mục</th>

        </tr>
        <c:forEach items="${listProduct}" var="detail">
            <tr>
                <td><c:out value="${detail.id}"/></td>
                <td><c:out value="${detail.name}"/></td>
                <td><fmt:formatNumber value="${detail.price}" pattern="###,###,###,###"/></td>
                <td><c:out value="${detail.quantity}"/></td>
                <td><c:out value="${detail.color}"/></td>
                <td><c:out value="${detail.description}"/></td>
                <td><c:out value="${detail.idCategory}"/></td>
                <td>
                    <a href="/list?action=edit&idEdit=${detail.id}">Edit</a>
                    <a href="/list?action=delete&id=${detail.id}" onclick="confirm('bạn chắc chưa')">Delete</a>
                        <%--                    <form action="/list" method="post">--%>
                        <%--                        <input type="hidden" name="action" value="delete">--%>
                        <%--                        <input type="hidden" name="id" value="${product.id}">--%>
                        <%--                        <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Delete</button>--%>
                        <%--                    </form>--%>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
