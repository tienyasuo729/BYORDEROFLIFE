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
        .form-edit, .form-delete,.form-pay {
            display: inline-block;
        }
    </style>
</head>
<body>
<center>
    <h1>Cầm đồ Tiến Thanh</h1>

        <form method="post" action="/tienthanh">
            <input type="hidden" name="action" value="create">
            <button type="submit" class="btn btn-success">Thêm Điện thoại cầm</button>
        </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="reload">
        <button class="btn btn-success">Tải lại trang</button>
    </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="watchLateList">
        <button class="btn btn-success">Xem danh sách trễ hạn</button>
    </form>
    <form method="post" action="/tienthanh">
        <input type="hidden" name="action" value="watchNearTermList">
        <button class="btn btn-success">Xem danh sách gần tới hạn</button>
    </form>
    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm CCCD theo mã số</h2>
            <input type="text" name="findByCccd" placeholder="Tìm kiếm theo mã số">
            <input type="hidden" value="search" name="action2">
            <button type="submit">Tìm kiếm</button> 
        </form>
    </div>

    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm CCCD theo tên</h2>
            <input type="text" name="findByName" placeholder="Tìm Điện Thoại theo tên">
            <input type="hidden" value="search" name="action2">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>
</center>
<div align="center">
    <table class="table table-hover"    STYLE="text-align: center">
        <h2>Danh sách CCCD cầm</h2>
        <caption><h2>Danh sách CCCD cầm</h2></caption>
        <tr>
            <th>STT</th>
            <th>Mã Số</th>
            <th>Họ và tên</th>
            <th>Loại máy</th>
            <th>Số tiền cầm</th>
            <th>Ngày cầm</th>
            <th>Tình trạng</th>
            <th>Mật khẩu</th>
            <th>Ghi chú</th>

        </tr>
        <% int count = 1; %>
        <c:forEach items="${listAndroid_Phone}" var="android_phone">
            <tr>
               <td><%=count%></td>
                <% count++; %>

                <td><c:out value="${android_phone.id}"/></td>
                <td><c:out value="${android_phone.name_owner}"/></td>
                <td><c:out value="${android_phone.name_phone}"/></td>
                <td><fmt:formatNumber value="${android_phone.price}" pattern="###,###,###,###"/></td>
                <td><fmt:formatDate value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${android_phone.status}"/></td>
                <td><c:out value="${android_phone.password}"/></td>
                <td><c:out value="${android_phone.note}"/></td>

<%--                <td>--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${android_phone.checkForDetail == 0}">--%>
<%--                            <form action="/tienthanh" method="post" class="form-edit">--%>
<%--                                <input type="hidden" name="action2" value="watchDetail">--%>
<%--                                <input type="hidden" name="idDetail" value="${android_phone.id}">--%>
<%--                                <button type="submit" class="btn btn-success" onclick="changeButtonText(this)">Xem chi tiết</button>--%>
<%--                            </form>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <button class="btn btn-success" onclick="window.alert('Chưa có thông tin của người này')">Không có chi tiết</button>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </td>--%>
                <td>
                    <form action="/tienthanh" method="post" class="form-edit">
                        <input type="hidden" name="action" value="edit_Android_phone">
                        <input type="hidden" name="id_need_to_edit" value="${android_phone.id}">
                        <button type="submit" class="btn btn-success">Chỉnh sửa</button>
                    </form>

                    <form action="/tienthanh" method="post" class="form-delete">
                        <input type="hidden" name="action2" value="delete_android_phone_by_id">
                        <input type="hidden" name="id_need_to_delete" value="${android_phone.id}">
                        <button type="submit" class="btn btn-danger"
                                onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Xoá
                        </button>
                    </form>
                    <form action="/tienthanh" method="post" class="form-pay">
                        <input type="hidden" name="action2" value="interestPayment">
                        <input type="hidden" name="id" value="${android_phone.id}">
                        <button type="submit" class="btn btn-warning">Tính  lãi</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script> //  script này để ngăn người dùng nhấn chuột phải rồi nhấn kiểm tra để xem được code html
    document.addEventListener("contextmenu", function(e){
        e.preventDefault();
    }, false);
</script>
</body>

</html>
