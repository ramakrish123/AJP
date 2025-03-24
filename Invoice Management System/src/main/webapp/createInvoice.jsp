<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Invoice</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container">
        <h1>Create Invoice</h1>
        <form action="createInvoice" method="post">
            Customer ID: <input type="text" name="customer_id" required><br>
            Invoice Date: <input type="date" name="invoice_date" required><br>
            Total Amount: <input type="text" name="total_amount" required><br>
            Payment Status: <input type="text" name="payment_status" required><br>
            <input type="submit" value="Create Invoice">
        </form>
    </div>
</body>
</html>