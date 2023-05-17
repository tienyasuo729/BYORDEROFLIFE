<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 17/05/2023
  Time: 12:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
  <h1>Mượn sách</h1>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Mượn sách</h2>
      </caption>
      <tr>
        <th>Mã mượn sách:</th>
        <td>
          <input type="text" name="create_id_loan_card" size="45" required="required"/>
        </td>
      </tr>
      <tr>
        <th>Tên sách:</th>
        <td>
          <input type="hidden" value="${create_name_book}">
          <input type="text" name="create_name_book" size="45" value="${create_id_book}" readonly/>
        </td>
      </tr>
      <tr>
        <th>Tên học sinh:</th>
        <td>
          <input type="text" name="create_name_student" size="45" >
          <%--                    <a><c:out value="${checkPrice}"></a>--%>
        </td>
      </tr>
      <tr>
        <th>Ngày mượn sách:</th>
        <td>
          <input type="date" name="create_date_borrow_book" size="45" readonly/>
        </td>
      </tr>
      <tr>
        <th>Ngày trả sách:</th>
        <td>
          <input type="date" name="create_date_return_book" size="45"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
