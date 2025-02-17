import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Include header
        RequestDispatcher headerDispatcher = request.getRequestDispatcher("/header");
        headerDispatcher.include(request, response);

        // Main content
        out.println("<div class='content'>");
        out.println("<h2>Welcome to the Home Page</h2>");
        out.println("<p>This is the home content.</p>");
        out.println("</div>");

        // Include footer
        RequestDispatcher footerDispatcher = request.getRequestDispatcher("/footer");
        footerDispatcher.include(request, response);
    }
}
