<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Student List</h2>
    <table class="table" border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Grade</th>
            <th>Actions</th>
        </tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) {
                for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getGrade() %></td>
            <td>
                <a class="button edit-btn" href="editStudent.jsp?id=<%= student.getId() %>&name=<%= student.getName() %>&age=<%= student.getAge() %>&grade=<%= student.getGrade() %>">
                    Edit
                </a>
                <form action="students" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this student?');">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input class="button delete-btn" type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5" style="text-align:center;">No students found.</td>
        </tr>
        <% } %>
    </table>

    <h2>Add Student</h2>
    <form action="students" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="grade">Grade:</label>
        <input type="text" id="grade" name="grade" required><br>

        <input class="button add-btn" type="submit" value="Add Student">
    </form>
</body>
</html>

