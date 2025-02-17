import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Add internal CSS styles for footer
        out.println("<style>");
        out.println(".footer {");
        out.println("    background: #333;");
        out.println("    color: white;");
        out.println("    text-align: center;");
        out.println("    padding: 10px;");
        out.println("    position: fixed;");
        out.println("    width: 100%;");
        out.println("    bottom: 0;");
        out.println("}");
        out.println("</style>");

        // Footer section
        out.println("<div class='footer'>");
        out.println("<p>&copy; 2025 My Website. All Rights Reserved.</p>");
        out.println("</div>");
    }
}
