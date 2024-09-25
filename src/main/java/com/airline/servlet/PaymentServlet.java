package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.Booking;
import com.airline.util.DatabaseConnection;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Booking b=new Booking();
        String upiOption = request.getParameter("upi_option")
        String upiId = request.getParameter("upi_id");
        String flightNumber = (b.getFlight_number());
        String departure = (b.getDeparture());
        String arrival = (b.getArrival());
        String departureTime = (b.getDeparture_time());
        String arrivalTime = (b.getArrival_time());
        String flightDate = (b.getFlight_date());
        String passengerName = (b.getPassenger_name());
        String email = (b.getEmail());

        // Set a default UPI ID for predefined options if not manually entered
        if (upiId == null || upiId.isEmpty()) {
            switch (upiOption) {
                case "google_pay":
                    upiId = "googlepay@upi";
                    break;
                case "phonepe":
                    upiId = "phonepe@upi";
                    break;
                case "bhim_upi":
                    upiId = "bhim@upi";
                    break;
            }
        }

        DatabaseConnection db = new DatabaseConnection();
        boolean isPaymentSuccessful = db.processPayment(upiOption, upiId, flightNumber, departure, arrival, departureTime, arrivalTime, flightDate, passengerName, email);

        if (isPaymentSuccessful) {
            response.sendRedirect("bookingSuccess.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
