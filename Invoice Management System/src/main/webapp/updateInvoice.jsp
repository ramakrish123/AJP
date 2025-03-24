<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Invoice</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container">
        <h1>Update Invoice</h1>
        <form action="updateInvoice" method="post">
            <input type="hidden" name="invoice_id" value="${param.id}">
            Customer ID: <input type="text" name="customer_id" value="${invoice.customer_id}" required><br>
            Invoice Date: <input type="date" name="invoice_date" value="${invoice.invoice_date}" required><br>
            Total Amount: <input type="text" name="total_amount" value="${invoice.total_amount}" required><br>
            Payment Status: <input type="text" name="payment_status" value="${invoice.payment_status}" required><br>
            <input type="submit" value="Update Invoice">
        </form>
    </div>
</body>
</html>