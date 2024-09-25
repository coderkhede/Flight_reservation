package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.Booking;
import com.airline.util.DatabaseConnection;

@WebServlet("/FlightBookingServlet")
public class FlightBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException 
    { 
    	
        String flightNumber = request.getParameter("flightNumber");
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        String flightDate = request.getParameter("flightDate");
        String passengerName = request.getParameter("passengerName");
        String email = request.getParameter("email");

        Booking b=new Booking();
        b.setArrival(arrival);
        b.setFlight_number(flightNumber);
        b.setFlight_date(flightDate);
        b.setDeparture(departure);
        b.setDeparture_time(departureTime);
        b.setArrival_time(arrivalTime);
        b.setPassenger_name(passengerName);
        b.setEmail(email);
        
        request.setAttribute("flightNumber", flightNumber);
        request.setAttribute("departure", departure);
        request.setAttribute("arrival", arrival);
        request.setAttribute("departureTime", departureTime);
        request.setAttribute("arrivalTime", arrivalTime);
        request.setAttribute("flightDate", flightDate);
        request.setAttribute("passengerName", passengerName);
        request.setAttribute("email", email);

        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }
}
