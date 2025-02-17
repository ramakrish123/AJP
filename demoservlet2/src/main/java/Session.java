import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionData")
public class Session extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Session() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the existing session
        HttpSession session = request.getSession(false);

        // Set the response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Session Data</title></head><body>");

        if (session != null) {
            String name = (String) session.getAttribute("name");
            String password = (String) session.getAttribute("password");

            if ("admin".equals(name) && "password".equals(password)) {
                // Display session ID if credentials match
                String sessionId = session.getId();
                out.println("<h1>Welcome, Admin!</h1>");
                out.println("<p>Your session ID is: " + sessionId + "</p>");
            } else {
                // If credentials don't match, show retry link
                out.println("<h1>Invalid Credentials</h1>");
                out.println("<p>Please <a href='logindetails.html'>Try Again</a></p>");
            }
        } else {
            // No session exists
            out.println("<h1>No session found!</h1>");
            out.println("<p>Please <a href='logindetails.html'>log in</a> first.</p>");
        }

        out.println("</body></html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}