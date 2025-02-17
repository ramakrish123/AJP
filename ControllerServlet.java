import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = request.getParameter("page");

        if (page == null || page.equals("home")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
            dispatcher.forward(request, response);
        } else if (page.equals("about")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/about");
            dispatcher.forward(request, response);
        } else if (page.equals("contact")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/contact");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("home"); // Redirect to home if page not found
        }
    }
}
