<%--
  Created by IntelliJ IDEA.
  User: micro
  Date: 10/19/2023
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="student" scope="request" class="com.example.sem4_java.entities.StudentEntity"/>
<a href="student-servlet">Quay lại trang danh sách</a>
<form action="student-servlet" method="POST">
    <input type="hidden" name="action" value="editStudent"/>
    <input  type="hidden" name="id" value="<%=student.getId()%>"/>
    <label for="name">Tên sinh viên:</label>
    <input type="text" id="name" name="name" value="<%=student.getName()%>" required><br>
    <label for="birthday">Ngày sinh:</label>
    <input type="date" id="birthday" name="birthday" value="${student.birthday}" required><br>
    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone" value="<%=student.getPhone()%>" required><br>
    <input type="submit" value="Sửa">
</form>
</body>
</html>
