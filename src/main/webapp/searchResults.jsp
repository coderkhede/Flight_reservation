<%@ page import="java.util.ArrayList" %>
<%@ page import="com.airline.model.Flight" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
    <h2>Search Results</h2>
    <table border="1" >
        <tr>
            <th>Flight Number</th>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Capacity</th>
            <th>Flight Date</th>
            <th>Price</th>
            <th>Book Now</th>
        </tr>
        <%
            ArrayList<Flight> flights = (ArrayList<Flight>) request.getAttribute("flights");
            for (Flight flight : flights) {
        %>
        <tr>
            <td><%= flight.getFlightNumber() %></td>
            <td><%= flight.getDeparture() %></td>
            <td><%= flight.getArrival() %></td>
            <td><%= flight.getDeparture_time() %></td>
            <td><%= flight.getArrival_time() %></td>
            <td><%= flight.getCapacity() %></td>
            <td><%= flight.getFlight_date() %></td>
            <td><%= flight.getPrice() %></td>
            <td>
                <form action="bookFlight.jsp" method="post">
                    <input type="hidden" name="flight_number" value="<%= flight.getFlightNumber() %>">
                    <input type="hidden" name="departure" value="<%= flight.getDeparture() %>">
                    <input type="hidden" name="arrival" value="<%= flight.getArrival() %>">
                    <input type="hidden" name="departure_time" value="<%= flight.getDeparture_time() %>">
                    <input type="hidden" name="arrival_time" value="<%= flight.getArrival_time() %>">
                    <input type="hidden" name="capacity" value="<%= flight.getCapacity() %>">
                    <input type="hidden" name="flight_date" value="<%= flight.getFlight_date() %>">
                    <input type="hidden" name="price" value="<%= flight.getPrice() %>">
                    <input type="submit" value="Book Now">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
<%@ include file="footer.jsp" %>
