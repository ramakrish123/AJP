<%@ page import="java.sql.*" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Student List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Grade</th>
        </tr>

        <%
            // JDBC Configuration
            String url = "jdbc:mysql://localhost:3306/SchoolDB";
            String user = "root";  // Your MySQL username
            String password = "12345678"; // Your MySQL password

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                conn = DriverManager.getConnection(url, user, password);

                // Create Statement
                stmt = conn.createStatement();

                // Execute Query
                String sql = "SELECT * FROM Students";
                rs = stmt.executeQuery(sql);

                // Iterate through results
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getInt("age") %></td>
                        <td><%= rs.getString("grade") %></td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (Exception ignored) {}
                if (stmt != null) try { stmt.close(); } catch (Exception ignored) {}
                if (conn != null) try { conn.close(); } catch (Exception ignored) {}
            }
        %>
    </table>
</body>
</html>
