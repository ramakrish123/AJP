<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.StudentDAO, model.Student" %>
<%@ page import="java.util.List" %>
<%@ include file="navbar.jsp" %>
<%
    StudentDAO studentDAO = new StudentDAO();
    List<Student> students = studentDAO.getAllStudents();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Students</title>
    <script>
        function editStudent(id, name, age, grade) {
            document.getElementById("id").value = id;
            document.getElementById("name").value = name;
            document.getElementById("age").value = age;
            document.getElementById("grade").value = grade;
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Grade</th>
            <th>Action</th>
        </tr>
        <% for (Student student : students) { %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getAge() %></td>
                <td><%= student.getGrade() %></td>
                <td>
                    <button onclick="editStudent('<%= student.getId() %>', '<%= student.getName() %>', '<%= student.getAge() %>', '<%= student.getGrade() %>')">Edit</button>
                </td>
            </tr>
        <% } %>
    </table>
    
    <h2>Edit Student</h2>
    <form action="students" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" id="id" name="id">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required>
        <br>
        
        <label for="grade">Grade:</label>
        <input type="text" id="grade" name="grade" required>
        <br>
        
        <input type="submit" value="Update Student">
    </form>
    <br>
    <a href="students.jsp">Back to Student List</a>
</body>
</html>
