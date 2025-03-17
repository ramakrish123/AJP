<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles.css"> <!-- Link to external CSS file -->
    <style>
        /* Navbar Styling */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .navbar {
            background-color: #333;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 20px;
        }

        .navbar .app-title {
            color: white;
            font-size: 24px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .nav-links {
            display: flex;
            gap: 15px;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
            font-size: 18px;
            transition: 0.3s;
            border-radius: 5px;
        }

        .nav-links a:hover {
            background-color: #ddd;
            color: black;
        }

        .user-info {
            color: white;
            font-size: 18px;
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .student-count {
            background-color: #28a745;
            padding: 5px 10px;
            border-radius: 10px;
            font-weight: bold;
            font-size: 16px;
            color: white;
        }

        .logout-btn {
            background-color: red;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: 0.3s;
        }

        .logout-btn:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>

    <nav class="navbar">
        <div class="app-title">STUDENT MANAGEMENT SYSTEM</div>
        
        <div class="nav-links">
            <a href="displayStudents.jsp">Home</a>
            <a href="addstudent.jsp">Add Student</a>
            <a href="editStudent.jsp">Edit Student</a>
            <a href="#" onclick="deleteStudentPrompt();">Delete Student</a>
        </div>

        <div class="user-info">
            <c:if test="${not empty sessionScope.username}">
                Welcome, ${sessionScope.username} 
                
                <!-- Display new students count -->
                <c:if test="${sessionScope.newStudents > 0}">
                    <span class="student-count">New: ${sessionScope.newStudents}</span>
                </c:if>

                <a href="LogoutServlet" class="logout-btn">Logout</a>
            </c:if>
        </div>
    </nav>

    <script>
        function deleteStudentPrompt() {
            var studentId = prompt("Enter Student ID to delete:");
            if (studentId != null && studentId !== "") {
                window.location.href = "deleteStudent.jsp?id=" + studentId;
            }
        }
    </script>

</body>
</html>
