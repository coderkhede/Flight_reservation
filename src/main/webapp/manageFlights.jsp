<%@page import="java.util.ArrayList"%>
<%@ page import="com.airline.model.Flight" %>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="css/manageCSS.css">

<main class="container">
    <h1>Manage Flights</h1>
    <div class="btn-group">
        <a href="addFlight.jsp" class="btn"><button>Add Flights</button></a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="GetAllFLightServlet" class="btn"><button>Edit Flights</button></a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="removeFlight.jsp" class="btn"><button>Remove Flights</button></a>
    </div>
    
    <h2>Flight List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Flight ID</th>
                <th>Flight Number</th>
                <th>Departure</th>
                <th>Arrival</th>
                <th>Flight Date</th>
                <th>Capacity</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        <%
        ArrayList<Flight> flightList = (ArrayList<Flight>) request.getAttribute("allflt");
        if (flightList == null || flightList.isEmpty()) {
            out.println("<tr><td colspan='9'>No flights found</td></tr>");
        } else {
            for (Flight flight : flightList) {
        %>
                <tr>
                    <td><%= flight.getId() %></td>
                    <td><%= flight.getFlightNumber() %></td>
                    <td><%= flight.getDeparture() %></td>
                    <td><%= flight.getArrival() %></td>
                    <td><%= flight.getFlight_date() %></td>
                    <td><%= flight.getCapacity() %></td>
                    <td><%= flight.getDeparture_time() %></td>
                    <td><%= flight.getArrival_time() %></td>
                    <td><%= flight.getPrice() %></td>
                </tr>
        <%
            }
        }
        %>
        </tbody>
    </table>
</main>
<%@ include file="/footer.jsp" %>
