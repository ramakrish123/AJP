package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/SchoolDB";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded authentication (replace with DB-based validation)
        if (("admin".equals(username) && "admin123".equals(password)) || 
            ("user".equals(username) && "user123".equals(password))||(username.equals(username) && password.equals(username))) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            int currentStudentCount = getStudentCount();
            int lastCount = 0;
            
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("studentCount")) {
                        lastCount = Integer.parseInt(cookie.getValue());
                    }
                }
            }
            
            Cookie studentCountCookie = new Cookie("studentCount", String.valueOf(currentStudentCount));
            studentCountCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
            response.addCookie(studentCountCookie);
            
            session.setAttribute("newStudents", Math.max(0, currentStudentCount - lastCount));
            
            // Redirect to StudentController to fetch student data
            response.sendRedirect("students");
        } else {
            response.sendRedirect("index.jsp?error=Invalid Credentials");
        }
    }

    private int getStudentCount() {
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM students");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
