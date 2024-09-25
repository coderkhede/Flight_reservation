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

import com.airline.model.User;
import com.airline.util.DatabaseConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DatabaseConnection db= new DatabaseConnection();
		
		User u= new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setRole(request.getParameter("role"));
		boolean isValid=db.verify(u);
		String target="";
		if (isValid==true) {
			HttpSession session = request.getSession(false);//it return old session
			if(session!=null)
			{
				session.invalidate();
			}
			session = request.getSession(true);//it will give a new session
			session.setAttribute("username", u.getUsername());
			

			if (u.getRole().equals("Admin"))
			{
				target="/manageFlights.jsp";
				ArrayList al = db.getAllFlightsList();
				request.setAttribute("allflt", al);
			}
			else 
			{
				target="/searchFlights.jsp";
			}
			
		} else {
			request.setAttribute("sms", "Invalid Username/password");
			target="/login.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
		
			
		}
		
	}


