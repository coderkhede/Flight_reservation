package com.airline.servlet;

import com.airline.model.Flight;
import com.airline.util.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String departure_time=request.getParameter("departure_time");
        String arrival_time = request.getParameter("arrival_time");
        double price = Double.parseDouble(request.getParameter("price"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String flightDate =request.getParameter("flight_date");

        Flight flight = new Flight();
        flight.setFlightNumber(flightNumber);
        flight.setDeparture(departure);
        flight.setArrival(arrival);
        flight.setDeparture_time(departure_time);
        flight.setArrival_time(arrival_time);
        flight.setPrice(price);
        flight.setCapacity(capacity);
        flight.setFlight_date(flightDate);

        DatabaseConnection db = new DatabaseConnection();
        
        try {
            boolean success = db.addFlight(flight);
            if (success) {
            	ArrayList<Flight> updatedFlights =db.getAllFlightsList();
            	request.setAttribute("allflt", updatedFlights);
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/manageFlights.jsp");
               rd.forward(request, response);
                
            } else {
                response.sendRedirect("addFlight.jsp?error=Failed to add flight");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("addFlight.jsp?error=Database error");
        }
    }
}
