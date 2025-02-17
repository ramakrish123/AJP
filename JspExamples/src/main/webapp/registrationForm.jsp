<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <div class="form-container">
        <h1>User Registration</h1>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                // Retrieve form data
                String fullName = request.getParameter("fullName");
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirmPassword");
                String gender = request.getParameter("gender");
                String country = request.getParameter("country");
                String bio = request.getParameter("bio");

                // Display the submitted data
        %>
                <h2>Registration Successful!</h2>
                <p><b>Full Name:</b> <%= fullName %></p>
                <p><b>Username:</b> <%= username %></p>
                <p><b>Email:</b> <%= email %></p>
                <p><b>Password:</b> <%= password %></p>
                <p><b>Gender:</b> <%= gender != null ? gender : "Not specified" %></p>
                <p><b>Country:</b> <%= country %></p>
                <p><b>Bio:</b> <%= bio != null && !bio.isEmpty() ? bio : "No bio provided" %></p>
                <a href="registrationForm.jsp">Register Again</a>
        <%
            } else {
        %>

        <form action="registrationForm.jsp" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required><br><br>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>

            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="Male">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="Female">
            <label for="female">Female</label><br><br>

            <label for="country">Country:</label>
            <select id="country" name="country" required><br><br>
                <option value="India">India</option>
                <option value="USA">USA</option>
                <option value="UK">UK</option>
                <option value="Australia">Australia</option>
                <option value="canada">Canada</option>
            </select><br><br>

            <label for="bio">Bio:</label>
            <textarea id="bio" name="bio" rows="4"></textarea><br><br>

            <button type="submit">Register</button>
        </form>
        <%
            }
        %>
    </div>
</body>
</html>
