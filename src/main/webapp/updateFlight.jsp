<%@page import="com.airline.model.Flight"%>
<%@ include file="header.jsp" %>

<section class="update-flight-form">
    <h2>Update Flight</h2>
    <%
        Flight flight = (Flight) request.getAttribute("flight");
        if (flight != null) {
    %>
    <form action="editFlightServlet" method="post">
        <input type="hidden" name="id" value="<%= flight.getId() %>">
        <div>
            <label for="flightNumber">Flight Number:</label>
            <input type="text" id="flightNumber" name="flightNumber" value="<%= flight.getFlightNumber() %>" required>
        </div>
        <div>
            <label for="departure">Departure:</label>
            <input type="text" id="departure" name="departure" value="<%= flight.getDeparture() %>" required>
        </div>
        <div>
            <label for="arrival">Arrival:</label>
            <input type="text" id="arrival" name="arrival" value="<%= flight.getArrival() %>" required>
        </div>
        <div>
            <label for="flightDate">Flight Date:</label>
            <input type="text" id="flightDate" name="flightDate" value="<%= flight.getFlight_date() %>" required>
        </div>
        <div>
            <label for="capacity">Capacity:</label>
            <input type="number" id="capacity" name="capacity" value="<%= flight.getCapacity() %>" required>
        </div>
        <div>
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" value="<%= flight.getPrice() %>" required>
        </div>
        <div>
            <label for="departureTime">Departure Time:</label>
            <input type="text" id="departureTime" name="departureTime" value="<%= flight.getDeparture_time() %>" required>
        </div>
        <div>
            <label for="arrivalTime">Arrival Time:</label>
            <input type="text" id="arrivalTime" name="arrivalTime" value="<%= flight.getArrival_time() %>" required>
        </div>
        <button type="submit" name="updateFlight" value="Update">Update Flight</button>
    </form>
    <%
        } else {
            out.println("Flight not found.");
        }
    %>
    <a href="editFlight.jsp">Back To Edit Flight Page</a>
</section>

<%@ include file="footer.jsp" %>
