package com.example.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.Invoice;
import com.example.dao.InvoiceDAO;

@WebServlet("/viewInvoices")
public class ViewInvoiceController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Invoice> invoices = InvoiceDAO.getAllInvoices();
        request.setAttribute("invoices", invoices); // Set invoice data in request
        request.getRequestDispatcher("home.jsp").forward(request, response); // Forward to home.jsp
    }
}