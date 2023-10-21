<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sem4_java.entities.StudentEntity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Students</title>
</head>
<body>
<a href="addStudent.jsp">Thêm sinh viên</a>
<script>
    function confirmDelete(studentName) {
        var result = confirm("Bạn có chắc chắn muốn xóa sinh viên " +studentName+" ?");
        if (result) {
            return true;
        } else {
            return false;
        }
    }
</script>
<jsp:useBean id="students" scope="request" type="java.util.List"/>
<jsp:useBean id="currentPageItems" scope="request" type="java.util.List"/>
<c:if test="${students.size()>0}">
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Số điện thoại</th>
        <th>Chính sửa</th>
        <th>Xóa</th>
    </tr>

    <%
        List<StudentEntity> studentsList = (List<StudentEntity>) students;
        List<StudentEntity> currentItems = (List<StudentEntity>) currentPageItems;
        for(StudentEntity student: currentItems) {
    %>
    <tr>
        <td><%=student.getName()%></td>
        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date birthday = student.getBirthday();
            String formattedBirthday = dateFormat.format(birthday);
        %>
        <td><%=formattedBirthday%></td>
        <td><%=student.getPhone()%></td>
        <td><form action="student-servlet" method="POST">
            <input type="hidden" name="action" value="edit"/>
            <input  type="hidden" name="id" value="<%=student.getId()%>"/>
            <button type="submit">Sửa</button>
        </form> </td>
        <td><form action="student-servlet" method="POST" onsubmit="return confirmDelete('<%=student.getName()%>')">
            <input type="hidden" name="id" value="<%=student.getId()%>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Xóa</button>
        </form></td>
    </tr>
    <%}%>
</table>
    <% int currentPage = Integer.parseInt(request.getParameter("page"));
        int totalItems = studentsList.size();
        int totalPages = (int) Math.ceil((double) totalItems / 2); %>

    <div>
        <% if (currentPage > 1) { %>
        <a href="?page=<%= currentPage - 1 %>">Previous</a>
        <% } %>

        <% if (currentPage < totalPages) { %>
        <a href="?page=<%= currentPage + 1 %>">Next</a>
        <% } %>
    </div>
</c:if>
<c:if test="${students.size()<1}">
    <h3>Not Found</h3>
</c:if>
</body>
</html>