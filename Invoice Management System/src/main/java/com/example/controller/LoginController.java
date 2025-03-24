package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        String password = request.getParameter("password");

        // Validate credentials (roll number as username and password)
        if (rollNumber.equals(password)) {
            // Create a session and set the rollNumber attribute
            HttpSession session = request.getSession();
            session.setAttribute("rollNumber", rollNumber);

            // Clear the newDataCount cookie after successful login
            Cookie newDataCookie = new Cookie("newDataCount", "");
            newDataCookie.setMaxAge(0); // Expire the cookie immediately
            response.addCookie(newDataCookie);

            // Redirect to ViewInvoiceController
            response.sendRedirect("viewInvoices");
        } else {
            // Redirect back to the login page if credentials are invalid
            response.sendRedirect("login.jsp");
        }
    }
}