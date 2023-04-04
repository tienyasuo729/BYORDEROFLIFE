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
</head>
<body>

<center>
    <h1>Add new product</h1>
    <h2>
        <a href="list?action=list">List product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${Product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="number" name="price" size="45"  placeholder="10.000.000" aria-valuemin="10000000"
                           value="<c:out value='${Product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>quantity:</th>
                <td>
                    <input type="number" name="quantity" size="15"
                           value="<c:out value='${Product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>color:</th>
                <td>
                    <select name="color">
                        <option value="red">red</option>
                        <option value="blue">blue</option>
                        <option value="Black">Black</option>
                        <option value="white">white</option>
                        <option value="yellow">yellow</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>description:</th>
                <td>
                    <input type="text" name="description" size="15"
                           value="<c:out value='${Product.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>category:</th>
                <td>
                    <select name="category">
                        <option value="phone">phone</option>
                        <option value="tivi">tivi</option>
                        <option value="tủ lạnh">tủ lạnh</option>
                        <option value="máy giặt">máy giặt</option>
                    </select>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>color:</th>--%>
<%--                <td>--%>
<%--                    <section name="color">--%>
<%--                        <option value="red">red</option>--%>
<%--                        <option value="blue">blue</option>--%>
<%--                        <option value="Black">Black</option>--%>
<%--                        <option value="white">white</option>--%>
<%--                        <option value="yellow">yellow</option>--%>
<%--                    </section>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Mã công việc:</th>--%>
<%--                <td>--%>
<%--                    <select name="maCongViec">--%>
<%--                        <c:forEach items="${listCongViec}" var="congViec">--%>
<%--                            <option value="${congViec.maCongViec}"><c:out value="${congViec.tenCongViec}"></c:out></option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
