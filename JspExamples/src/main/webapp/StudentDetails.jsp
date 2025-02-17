<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %><%@ page import="test.Student" %>
<%@ page import="test.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
    
</head>
<body>
  <h1>Student Information</h1>
   <%
      Student student = new Student("Ramakrishna", 20, "22VV1A1249", "IT");
    %>
    
   <p>Name: <%= student.getName() %></p>
   <p>Age: <%= student.getAge() %></p>
   <p>Roll Number: <%= student.getRollNumber() %></p>
   <p>Department: <%= student.getDepartment() %></p>
</body>
</html>
