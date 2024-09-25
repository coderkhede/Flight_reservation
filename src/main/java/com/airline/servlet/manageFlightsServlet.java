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

@WebServlet("/manageFlightsServlet")
public class manageFlightsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnection db = new DatabaseConnection();
        ArrayList<Flight> flightList = db.getAllFlightsList();
        request.setAttribute("allflt", flightList);
        RequestDispatcher rd = request.getRequestDispatcher("/manageFlight.jsp");
        rd.forward(request, response);
    }
}
