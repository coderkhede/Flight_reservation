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

@WebServlet("/editFlightServlet")
public class EditFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String flightNumber = request.getParameter("flightNumber");
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String flightDate = request.getParameter("flightDate");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");

        Flight flight = new Flight();
        flight.setId(id);
        flight.setFlightNumber(flightNumber);
        flight.setDeparture(departure);
        flight.setArrival(arrival);
        flight.setFlight_date(flightDate);
        flight.setCapacity(capacity);
        flight.setPrice(price);
        flight.setDeparture_time(departureTime);
        flight.setArrival_time(arrivalTime);

        DatabaseConnection db = new DatabaseConnection();
        boolean isUpdated = db.updateFlight(flight);

        String message;
        if (isUpdated) {
            message = "Flight details updated successfully!";
        } else {
            message = "Failed to update flight details.";
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("/editFlight.jsp");
        rd.forward(request, response);
    }
}
