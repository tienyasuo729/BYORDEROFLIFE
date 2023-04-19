<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Tiệm cầm đồ Tiến Thanh</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
    .form-edit, .form-delete {
      display: inline-block;
    }

    .form-edit button, .form-delete button {
      margin-left: 10px;
    }
  </style>
</head>
<body>
<center>
  <h1>Cầm đồ Tiến Thanh</h1>
  <h2>
    <form method="post" action="/list">
      <input type="hidden" name="action" value="create">
      <button class="btn btn-success">Thêm CCCD cầm mới</button>
    </form>
  </h2>

  <div class="search">
    <form action="/list" method="post">
      <h2>Tìm kiếm CCCD theo mã số</h2>
      <input type="text" name="findName" placeholder="Tìm kiếm theo mã số CCCD">
      <input type="hidden" value="search" name="action2">
      <button type="submit">Tìm kiếm</button>
    </form>
  </div>

  <div class="search">
    <form action="/list" method="post">
      <h2>Tìm kiếm CCCD theo tên</h2>
      <input type="text" name="findName" placeholder="Tìm CCCD theo tên">
      <input type="hidden" value="search" name="action2">
      <button type="submit">Tìm kiếm</button>
    </form>
  </div>
</center>
<div align="center">
  <table class="table table-hover">
    <h2>Danh sách CCCD cầm</h2>
    <caption><h2>Danh sách CCCD cầm</h2></caption>
    <tr>
      <th>CCCD</th>
      <th>Họ và Tên</th>
      <th>Số tiền cầm</th>
      <th>Ngày cầm</th>
      <th>Chi tiết</th>

    </tr>
    <c:forEach items="${listCCCD}" var="CCCD">
      <tr>
        <td><c:out value="${CCCD.cccd}"/></td>
        <td><c:out value="${CCCD.name}"/></td>
        <td><fmt:formatNumber value="${CCCD.price}" pattern="###,###,###,###"/></td>
        <td><fmt:formatDate value="${CCCD.startDate}" pattern="dd/MM/yyyy"/></td>
        <td><c:out value="${CCCD.checkForDetail}"/></td>
        <td>
          <form action="/list" method="post" class="form-edit">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="idEdit" value="${CCCD.cccd}">
            <button type="submit" class="btn btn-success"
                    onclick="return confirm('Bạn chắc chắn có muốn sửa không ?')">Edit
            </button>
          </form>

          <form action="/list" method="post" class="form-delete">
            <input type="hidden" name="action2" value="delete">
            <input type="hidden" name="id" value="${CCCD.cccd}">
            <button type="submit" class="btn btn-danger"
                    onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Delete
            </button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
