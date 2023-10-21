<%--
  Created by IntelliJ IDEA.
  User: micro
  Date: 10/19/2023
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="student-servlet">Quay lại trang danh sách</a>
<form action="student-servlet" method="POST">
    <input type="hidden" name="action" value="addStudent"/>
    <label for="name">Tên sinh viên:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="birthday">Ngày sinh:</label>
    <input type="date" id="birthday" name="birthday" required><br>
    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone" required><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>
