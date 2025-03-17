package Controller;

import model.StudentDAO;
import model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = new StudentDAO();

    // Display all students
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = studentDAO.getAllStudents();
        request.setAttribute("students", studentList);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    
    }

    // Handle adding, updating, and deleting students
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String grade = request.getParameter("grade");

            Student student = new Student(name, age, grade);
            studentDAO.addStudent(student);
            response.sendRedirect("students");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String grade = request.getParameter("grade");

            Student student = new Student(id, name, age, grade);
            studentDAO.updateStudent(student);
            response.sendRedirect("students");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            studentDAO.deleteStudent(id);
            response.sendRedirect("students");
        }
    }
}
