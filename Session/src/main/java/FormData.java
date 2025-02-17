import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FormData")
public class FormData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FormData() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Create or retrieve the session
        HttpSession session = request.getSession();

        // Store the credentials in the session
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        // Redirect to SessionData servlet
        response.sendRedirect("SessionData");
    }
}