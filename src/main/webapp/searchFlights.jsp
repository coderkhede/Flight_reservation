<%@page import="java.util.ArrayList"%>
<%@page import="com.airline.model.Flight"%>
<%@ include file="header.jsp" %>
<title>Search Flights</title>

<link rel="stylesheet" href="css/searchFlightCSS.css">
<div ><p><h1 color='white'>Enter the From where you want to go in Departure and to where are you going in Arrival for seeing your flights which are from your place to destination thank you. </h1></p></div>
<section class="search-flights-form">
     <h2>Search Flights</h2>
    <form action="SearchFlightsServlet" method="get">
        <label for="departure">Departure:</label>
        <input type="text" id="departure" name="departure" required><br><br>
        
        <label for="arrival">Arrival:</label>
        <input type="text" id="arrival" name="arrival" required><br><br>
        
        <input type="submit" value="Search">
    </form>
    
</section>
<%@include file ="footer.jsp" %>

