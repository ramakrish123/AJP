<nav>
    <div class="navbar">
        <span class="system-name">Invoice Management System</span>
        <div>
            <a href="home.jsp">Home</a>
            <a href="createInvoice.jsp">Create Invoice</a>
            <a href="viewInvoices">View Invoices</a>
        </div>
        <span class="welcome-message">Welcome, <%= session.getAttribute("rollNumber") %></span>
        <span id="newDataCount" class="new-data-count"></span> <!-- New Data Count -->
        <a href="logout" class="logout">Logout</a>
    </div>
</nav>

<script>
    // Function to get the value of a cookie by name
    function getCookie(name) {
        const value = `; ${document.cookie}`;
        const parts = value.split(`; ${name}=`);
        if (parts.length === 2) return parts.pop().split(';').shift();
    }

    // Retrieve the newDataCount cookie
    const newDataCount = getCookie('newDataCount');

    // Display the new data count in the navbar
    if (newDataCount) {
        document.getElementById('newDataCount').textContent = `New Data: ${newDataCount}`;
    }
</script>