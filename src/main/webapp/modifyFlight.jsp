<%@page import="com.airline.model.Flight"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Flight</title>
</head>
<body>

<%@ include file="header.jsp" %>
<br>
<%
    String sms = (String) request.getAttribute("sms");
    if (sms != null) {
        out.print(sms);
    }

    Flight f = (Flight) request.getAttribute("flight1");
    if (f != null) {
%>
    <form action="EditFlightServlet" method="post">
        <div>
            <input type="text" value="<%= f.getFlightNumber() %>" name="flight_Number" required>
            <label for="flight_Number">Flight Number</label>
        </div>
        <div>
            <input type="text" value="<%= f.getDeparture() %>" name="departure" required>
            <label for="departure">Flight Departure</label>
        </div>
        <div>
            <input type="text" value="<%= f.getArrival() %>" name="arrival" required>
            <label for="arrival">Flight Arrival</label>
        </div>
        <div>
            <input type="number" value="<%= f.getCapacity() %>" name="capacity" required>
            <label for="capacity">Flight Capacity</label>
        </div>
        <div>
            <input type="number" value="<%= f.getPrice() %>" name="price" required>
            <label for="price">Price</label>
        </div>
        <div>
            <input type="text" value="<%= f.getDeparture_time() %>" name="departure_time" required>
            <label for="departure_time">Departure Time</label>
        </div>
        <div>
            <input type="text" value="<%= f.getArrival_time() %>" name="arrival_time" required>
            <label for="arrival_time">Arrival Time</label>
        </div>
        <div>
            <input type="text" value="<%= f.getFlight_date() %>" name="flight_date" required>
            <label for="flight_date">Flight Date</label>
        </div>
        <button type="submit" name="m1" value="Edit Flight">Edit Flight</button>
    </form>
<%
    }
%>
<br>
<%@include file="footer.jsp" %>
</body>
</html>
