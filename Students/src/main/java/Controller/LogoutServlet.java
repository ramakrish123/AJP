package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); // Get existing session, if any
        if (session != null) {
            session.invalidate(); // Destroy session
        }

        // Ensure student count cookie is not removed
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("studentCount".equals(cookie.getName())) {
                    cookie.setMaxAge(30 * 24 * 60 * 60); // Extend for 30 days
                    response.addCookie(cookie);
                }
            }
        }

        response.sendRedirect("index.jsp"); // Redirect to login page
    }
}
