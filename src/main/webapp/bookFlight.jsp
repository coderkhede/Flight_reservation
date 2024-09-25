<%@ include file="header.jsp" %>

<section class="book-flight-form">
     <h2>Book Flight</h2>
    <form action="FlightBookingServlet" method="post">
        <label for="flight_number">Flight Number:</label>
        <input type="text" id="flight_number" name="flight_number" value="<%= request.getParameter("flight_number") %>" readonly><br><br>
        
        <label for="departure">Departure:</label>
        <input type="text" id="departure" name="departure" value="<%= request.getParameter("departure") %>" readonly><br><br>
        
        <label for="arrival">Arrival:</label>
        <input type="text" id="arrival" name="arrival" value="<%= request.getParameter("arrival") %>" readonly><br><br>
        
        <label for="departure_time">Departure Time:</label>
        <input type="text" id="departure_time" name="departure_time" value="<%= request.getParameter("departure_time") %>" readonly><br><br>
        
        <label for="arrival_time">Arrival Time:</label>
        <input type="text" id="arrival_time" name="arrival_time" value="<%= request.getParameter("arrival_time") %>" readonly><br><br>
        
        <label for="flight_date">Flight Date:</label>
        <input type="date" id="flight_date" name="flight_date"  value="<%=request.getParameter("flight_date")%>"><br><br>
        
        <label for="passenger_name">Passenger Name:</label>
        <input type="text" id="passenger_name" name="passenger_name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="AadharNo">Aadhar Card No.:</label>
        <input type="text" id="AadharNo" name="AadharNo" required><br><br>
        
        <input type="submit" value="Book Flight">
    </form>
</section>

<%@ include file="footer.jsp" %>
