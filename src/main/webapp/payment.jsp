<%@include file="header.jsp"%>
<link rel="stylesheet" href="css/paymentCSS.css">

<title>Payment</title>

<script type="text/javascript">
    function showQRCode() {
        document.getElementById("qrCodeImage").style.display = "block";
        setTimeout(function() {
            window.location.href = "paymentTimeout.jsp";
        }, 60000); // 1 minute in milliseconds
    }

    function toggleUPIInput(option) {
        if (option === 'manual') {
            document.getElementById("upi_id").style.display = "block";
        } else {
            document.getElementById("upi_id").style.display = "none";
        }
    }
</script>

<h2>Payment</h2>
<form action="PaymentServlet" method="post">
    <div>
        <label>Pay through UPI:</label><br>
        <input type="radio" name="upi_option" value="google_pay" id="google_pay" onclick="toggleUPIInput('google_pay')">
        <label for="google_pay">
            <img src="images/Gpay.jpeg" alt="Google Pay" style="width: 50px; height: 50px;">
        </label>
        
        <input type="radio" name="upi_option" value="phonepe" id="phonepe" onclick="toggleUPIInput('phonepe')">
        <label for="phonepe">
            <img src="images/PhonePe.jpeg" alt="PhonePe" style="width: 50px; height: 50px;">
        </label>
        
        <input type="radio" name="upi_option" value="bhim_upi" id="bhim_upi" onclick="toggleUPIInput('bhim_upi')">
        <label for="bhim_upi">
            <img src="images/Bhim.jpeg" alt="BHIM UPI" style="width: 50px; height: 50px;">
        </label>
        
        <input type="radio" name="upi_option" value="manual" id="manual" onclick="toggleUPIInput('manual')">
        <label for="manual">Enter UPI ID manually</label>
    </div>
    <br>
    <div id="upi_id" style="display: none;">
        <label for="upi_id_input">UPI ID:</label>
        <input type="text" id="upi_id_input" name="upi_id" placeholder="none">
    </div>
    
    <input type="hidden" name="flight_number" value="<%= request.getParameter("flight_number") %>">
    <input type="hidden" name="departure" value="<%= request.getParameter("departure") %>">
    <input type="hidden" name="arrival" value="<%= request.getParameter("arrival") %>">
    <input type="hidden" name="departure_time" value="<%= request.getParameter("departure_time") %>">
    <input type="hidden" name="arrival_time" value="<%= request.getParameter("arrival_time") %>">
    <input type="hidden" name="flight_date" value="<%= request.getParameter("flight_date") %>">
    <input type="hidden" name="passenger_name" value="<%= request.getParameter("passenger_name") %>">
    <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
    
    <input type="submit" value="Submit UPI ID">
</form>

<button onclick="showQRCode()">Show QR Code</button>
<div id="qrCodeImage" style="display: none;">
    <img src="images/QR code.jpeg" alt="QR Code for Payment" style="width: 200px; height: 200px;">
</div>

<%@include file="footer.jsp"%>
