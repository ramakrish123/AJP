<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Add Student</h2>
    <form action="students" method="post" class="form-container">
        <!-- Hidden field to specify the action -->
        <input type="hidden" name="action" value="add">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="grade">Grade:</label>
        <input type="text" id="grade" name="grade" required><br>

        <input type="submit" value="Add Student" class="button">
    </form>
</div>

</body>
</html>

