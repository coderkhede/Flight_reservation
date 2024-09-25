
<%@ page import="com.airline.model.User" %>
<%@ page import="com.airline.model.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<link rel="stylesheet" href="css/removeFlightCSS.css">

<%@ include file="header.jsp" %>
   
        <div class="container">
            <h1>Remove Flight</h1>
            <form action="RemoveFlightServlet" >
                <div class="form-group">
                    <label for="flightNumber">Flight Number:
                    <input type="text" id="flight_Number" name="flight_Number" required>
                    </label>
                </div>
                <button type="submit" class="btn">Remove Flight</button>
            </form>
        </div>
    <%@ include file="footer.jsp"%>