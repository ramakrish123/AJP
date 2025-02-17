<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Declaration Example</title>
</head>
<body>
    <h1>JSP Declaration Tag Example</h1>
    <h3>Hello world of java</h3>
     The time on the server is <%=new java.util.Date() %>
    
   
    <%! int visitCount = 0; %>

    <%! 
    public String greetUser(String name) {
        return "Hello, " + name + "!";
    }
    %>
    <%
        visitCount++;
   
    %>
    
    <p><b>Visit Count:</b> <%= visitCount %></p>
    

    <p><b>Greeting:</b> <%= greetUser("Ramakrishna") %></p>
    
   
    <%! final String APP_NAME = "My JSP Application"; %>
    <p><b>Application Name:</b> <%= APP_NAME %></p>
</body>
</html>
