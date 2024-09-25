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

@WebServlet("/RemoveFlightServlet")
public class RemoveFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flight_Number");

        DatabaseConnection db = new DatabaseConnection();
        
        try {
            boolean success = db.removeFlight(flightNumber);
            if (success) {
            	ArrayList<Flight> updatedFlights =db.getAllFlightsList();
            	request.setAttribute("allflt", updatedFlights);
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/manageFlights.jsp");
               rd.forward(request, response);
               
            } else {
                response.sendRedirect("manageFlights.jsp?error=Failed to remove flight");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("manageFlights.jsp?error=Database error");
        }
    }
}
