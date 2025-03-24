<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container">
        <h1>Welcome to Invoice Management System</h1>
        <table class="home-table">
            <thead>
                <tr>
                    <th>Invoice ID</th>
                    <th>Customer ID</th>
                    <th>Invoice Date</th>
                    <th>Total Amount</th>
                    <th>Payment Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${invoices}" var="invoice">
                    <tr>
                        <td>${invoice.invoice_id}</td>
                        <td>${invoice.customer_id}</td>
                        <td>${invoice.invoice_date}</td>
                        <td>${invoice.total_amount}</td>
                        <td>${invoice.payment_status}</td>
                        <td>
                            <a href="updateInvoice.jsp?id=${invoice.invoice_id}" class="button">Edit</a>
                            <a href="deleteInvoice?id=${invoice.invoice_id}" class="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
