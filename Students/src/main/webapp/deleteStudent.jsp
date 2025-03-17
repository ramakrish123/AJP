<%@ page import="model.StudentDAO" %>
<%
    // Get the student ID from the request
    String idParam = request.getParameter("id");

    if (idParam != null && !idParam.isEmpty()) {
        try {
            int studentId = Integer.parseInt(idParam);
            StudentDAO dao = new StudentDAO();
            
            boolean success = dao.deleteStudent(studentId);
            
            if (success) {
                out.println("<h3 style='color:green;'>Student with ID " + studentId + " deleted successfully!</h3>");
            } else {
                out.println("<h3 style='color:red;'>Failed to delete student. ID may not exist.</h3>");
            }
        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Invalid Student ID.</h3>");
        }
    } else {
        out.println("<h3 style='color:red;'>No Student ID provided.</h3>");
    }
%>

<!-- Back to Student List -->
<a href="displayStudents.jsp">Back to Student List</a>
