package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.Invoice;
import com.example.dao.InvoiceDAO;

@WebServlet("/updateInvoice")
public class UpdateInvoiceController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(Integer.parseInt(request.getParameter("invoice_id")));
        invoice.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
        try {
            invoice.setInvoice_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("invoice_date")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        invoice.setTotal_amount(Double.parseDouble(request.getParameter("total_amount")));
        invoice.setPayment_status(request.getParameter("payment_status"));

        InvoiceDAO.updateInvoice(invoice);
        response.sendRedirect("viewInvoices");
    }
}