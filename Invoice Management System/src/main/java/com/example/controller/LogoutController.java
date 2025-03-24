package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session
        HttpSession session = request.getSession();
        session.invalidate();

        // Calculate the new data count (e.g., number of new invoices)
        int newDataCount = calculateNewDataCount(); // Replace with your logic

        // Create a cookie to store the new data count
        Cookie newDataCookie = new Cookie("newDataCount", String.valueOf(newDataCount));
        newDataCookie.setMaxAge(7 * 24 * 60 * 60); // Cookie expires in 7 days
        response.addCookie(newDataCookie);

        // Redirect to the login page
        response.sendRedirect("login.jsp");
    }

    // Method to calculate the new data count (replace with your logic)
    private int calculateNewDataCount() {
        // Example: Fetch the count of new invoices from the database
        // int newInvoicesCount = invoiceService.getNewInvoicesCount();
        // return newInvoicesCount;

        // For now, return a dummy value
        return 5; // Replace with actual logic
    }
}