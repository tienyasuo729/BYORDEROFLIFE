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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .form-edit, .form-delete {
            display: inline-block;
        }
        .form-payment{
            display: inline;
        }
        .action-buttons {
            display: inline-block;
            flex-direction: column;
            gap: 10px;
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
    <table class="table table-hover" STYLE="text-align: center">
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
                <td><%=count%>
                </td>
                <% count++; %>

                <td><c:out value="${android_phone.id}"/></td>
                <td><c:out value="${android_phone.name_owner}"/></td>
                <td><c:out value="${android_phone.name_phone}"/></td>
                <td><fmt:formatNumber value="${android_phone.price}" pattern="###,###,###,###"/></td>
                <td ><fmt:formatDate  value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${android_phone.status}"/></td>
                <td><c:out value="${android_phone.password}"/></td>
                <td><c:out value="${android_phone.note}"/></td>
                <td>
                    <div>
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
                    </div>

                    <div class="action-buttons">
                        <button type="button" class="btn btn-warning" onclick="calculate('${android_phone.id}','${android_phone.start_Date}', '${android_phone.price}')">Gia hạn</button>
                        <button type="button" class="btn btn-info" onclick="take_the_product('${android_phone.id}','${android_phone.start_Date}', '${android_phone.price}')">Lấy máy</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script> //  script này để ngăn người dùng nhấn chuột phải rồi nhấn kiểm tra để xem được code html
document.addEventListener("contextmenu", function (e) {
    e.preventDefault();
}, false);

function take_the_product(id,startDate,price){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var result = this.responseText;
            alert(result);
            let check = confirm("Khách đã chắc chắn lấy máy không");
            if (check === true){
                delete_after_take_the_product(id,startDate);
            }
        }
    };
    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=take_the_product_out" + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&price_interest_payment=" + encodeURIComponent(price); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
}

function calculate(id, startDate, price) {
    let days;
    do {
        days = +prompt("Nhập số ngày cầm tính lãi");
    }while (isNaN(days));
    console.log(days);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var result = this.responseText;
            alert(result);
            let check = confirm("bạn có muốn gia hạn không");
            if (check === true){
                extend_start_date(id,startDate,days);
            }
        }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=interestPayment" + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&price_interest_payment=" + encodeURIComponent(price) + "&days_interest_payment=" + encodeURIComponent(days); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
}
function extend_start_date(id, startDate, days){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var result = this.responseText;
            alert(result);
        }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=extend_interest_payment&id_extend_interest_payment=" + encodeURIComponent(id) + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&days_interest_payment=" + encodeURIComponent(days); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
}

function delete_after_take_the_product(id,startDate){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var result = this.responseText;
            alert("Lấy máy thành công");
        }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=delete_android_phone_by_id&id_need_to_delete=" + encodeURIComponent(id) + "&start_date_interest_payment=" + encodeURIComponent(startDate); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
}

</script>
</body>

</html>
