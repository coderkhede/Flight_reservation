package com.airline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.util.DatabaseConnection;

/**
 * Servlet implementation class GetAllFLightServlet
 */
@WebServlet("/GetAllFLightServlet")
public class GetAllFLightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection db = new DatabaseConnection();
		ArrayList al = db.getAllFlightsList();
		System.out.println("size = "+al.size());
		request.setAttribute("alF", al);
		HttpSession session=request.getSession(false);
		session.setAttribute("allflights", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/editFlight.jsp");
		rd.forward(request, response);
	}

}
