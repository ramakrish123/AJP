<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Handling in JSP</title>
</head>
<body>
    <h1>Form Handling Example</h1>

    <%
       
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Retrieve form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String[] hobbies = request.getParameterValues("hobbies");
            String country = request.getParameter("country");
            String comments = request.getParameter("comments");

            // Display the submitted data
    %>
            <h2>Form Data Received</h2>
            <p><b>Name:</b> <%= name %></p>
            <p><b>Email:</b> <%= email %></p>
            <p><b>Password:</b> <%= password %></p>
            <p><b>Age:</b> <%= age != null && !age.isEmpty() ? age : "Not provided" %></p>
            <p><b>Gender:</b> <%= gender != null ? gender : "Not specified" %></p>
            <p><b>Hobbies:</b> <%= hobbies != null ? String.join(", ", hobbies) : "None" %></p>
            <p><b>Country:</b> <%= country %></p>
            <p><b>Comments:</b> <%= comments != null && !comments.isEmpty() ? comments : "No comments" %></p>

            <a href="form.jsp">Back to Form</a>
    <%
        } else {
    %>

    <!-- Display the form -->
    <form action="form.jsp" method="post">
        <!-- Text Input -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <!-- Email Input -->
        <label for="email">Email:</label>
        <input type="email" id="email"  required><br><br>

        <!-- Password Input -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <!-- Number Input -->
        <label for="age">Age:</label>
        <input type="number" id="age" name="age"><br><br>

        <!-- Radio Buttons -->
        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="Male">
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female">
        <label for="female">Female</label><br><br>

        <!-- Checkbox -->
        <label>Hobbies:</label>
        <input type="checkbox" id="hobby1" name="hobbies" value="Reading">
        <label for="hobby1">Reading</label>
        <input type="checkbox" id="hobby2" name="hobbies" value="Traveling">
        <label for="hobby2">Traveling</label>
        <input type="checkbox" id="hobby3" name="hobbies" value="Playing">
        <label for="hobby3">Playing</label>
        <input type="checkbox" id="hobby4" name="hobbies" value="Singing">
        <label for="hobby3">Singing</label>
       <br><br>

        <!-- Dropdown -->
        <label for="country">Country:</label>
        <select id="country" name="country">
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="UK">UK</option>
        </select><br><br>

        <!-- Textarea -->
        <label for="comments">Comments:</label>
        <textarea id="comments" name="comments"></textarea><br><br>

        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>

    <%
        }
    %>
</body>
</html>
