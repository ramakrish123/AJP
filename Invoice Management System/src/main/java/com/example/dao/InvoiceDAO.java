package com.example.dao;

import com.example.model.Invoice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/InvoiceDB";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new invoice
    public static void createInvoice(Invoice invoice) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Invoice (customer_id, invoice_date, total_amount, payment_status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, invoice.getCustomer_id());
            stmt.setDate(2, new java.sql.Date(invoice.getInvoice_date().getTime()));
            stmt.setDouble(3, invoice.getTotal_amount());
            stmt.setString(4, invoice.getPayment_status());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch all invoices
    public static List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Invoice";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoice_id(rs.getInt("invoice_id"));
                invoice.setCustomer_id(rs.getInt("customer_id"));
                invoice.setInvoice_date(rs.getDate("invoice_date"));
                invoice.setTotal_amount(rs.getDouble("total_amount"));
                invoice.setPayment_status(rs.getString("payment_status"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    // Method to update an invoice
    public static void updateInvoice(Invoice invoice) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE Invoice SET customer_id=?, invoice_date=?, total_amount=?, payment_status=? WHERE invoice_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, invoice.getCustomer_id());
            stmt.setDate(2, new java.sql.Date(invoice.getInvoice_date().getTime()));
            stmt.setDouble(3, invoice.getTotal_amount());
            stmt.setString(4, invoice.getPayment_status());
            stmt.setInt(5, invoice.getInvoice_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an invoice
    public static void deleteInvoice(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM Invoice WHERE invoice_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}