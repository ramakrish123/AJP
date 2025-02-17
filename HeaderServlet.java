import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       
        out.println("<style>");
        out.println(".header { background: #333; color: white; text-align: center; padding: 10px; }");
        out.println(".navbar { background: #444; padding: 10px; }");
        out.println(".navbar ul { list-style: none; margin: 0; padding: 0; text-align: center; }");
        out.println(".navbar li { display: inline; margin-right: 20px; }");
        out.println(".navbar a { color: white; text-decoration: none; font-weight: bold; }");
        out.println(".navbar a:hover { color: #ffcc00; }");
        out.println("</style>");

       
        out.println("<div class='header'>");
        out.println("<h2>My Website</h2>");
        out.println("</div>");

        out.println("<nav class='navbar'>");
        out.println("<ul>");
        out.println("<li><a href='controller?page=home'>Home</a></li>");
        out.println("<li><a href='controller?page=about'>About</a></li>");
        out.println("<li><a href='controller?page=contact'>Contact</a></li>");
        out.println("</ul>");
        out.println("</nav>");
    }
}
