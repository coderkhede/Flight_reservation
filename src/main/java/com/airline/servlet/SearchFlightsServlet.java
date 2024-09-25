package com.airline.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.Flight;
import com.airline.util.DatabaseConnection;

@WebServlet("/SearchFlightsServlet")
public class SearchFlightsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");

       DatabaseConnection db =new DatabaseConnection();
        ArrayList<Flight> flights = db.searchFlights(departure, arrival);

        request.setAttribute("flights", flights);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchResults.jsp");
        rd.forward(request, response);
    }
}
