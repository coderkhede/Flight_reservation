<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="css/addFlightCSS.css">
<body>
    <div class="add-flight-container">
        <section class="add-flight-form">
            <h2>Add New Flight</h2>
            <form action="AddFlightServlet" method="post">
                <table>
                    <tr>
                        <td><label for="flightNumber">Flight Number:</label></td>
                        <td><input type="text" name="flightNumber" placeholder="Flight Number" required></td>
                    </tr>
                    <tr>
                        <td><label for="departure">Departure:</label></td>
                        <td><input type="text" name="departure" placeholder="Departure" required></td>
                    </tr>
                    <tr>
                        <td><label for="arrival">Arrival:</label></td>
                        <td><input type="text" name="arrival" placeholder="Arrival" required></td>
                    </tr>
                    <tr>
                        <td><label for="flight_date">Flight Date:</label></td>
                        <td><input type="text" name="flight_date" placeholder="dd-mm-yyyy" required></td>
                    </tr>
                    <tr>
                        <td><label for="departure_time">Departure Time:</label></td>
                        <td><input type="text" name="departure_time" placeholder="Departure time" required></td>
                    </tr>
                    <tr>
                        <td><label for="arrival_time">Arrival Time:</label></td>
                        <td><input type="text" name="arrival_time" placeholder="Arrival time" required></td>
                    </tr>
                    <tr>
                        <td><label for="price">Price:</label></td>
                        <td><input type="number" name="price" placeholder="Price" step="0.01" required></td>
                    </tr>
                    <tr>
                        <td><label for="capacity">Capacity:</label></td>
                        <td><input type="number" name="capacity" placeholder="Capacity" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="center-button">
                            <button type="submit">Add Flight</button>
                        </td>
                    </tr>
                </table>
            </form>
        </section>
    </div>
   
<%@ include file="/footer.jsp"%>