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
import java.util.ArrayList;

@WebServlet("/getFlightServlet")
public class GetFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");

        DatabaseConnection db = new DatabaseConnection();
        Flight flight = db.getFlightByNumber(flightNumber);
        ArrayList<Flight> flightList = db.getFlights();

        request.setAttribute("flightList", flightList);
        request.setAttribute("flight", flight);

        RequestDispatcher rd = request.getRequestDispatcher("/updateFlight.jsp");
        rd.forward(request, response);
    }
}
