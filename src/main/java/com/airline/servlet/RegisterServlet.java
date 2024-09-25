package com.airline.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.User;
import com.airline.util.DatabaseConnection;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 User u = new User();
	 u.setUsername(request.getParameter("username"));
	 u.setPassword(request.getParameter("password"));
	 u.setEmail(request.getParameter("email"));
	 u.setRole("Customer");
	 
	 DatabaseConnection db = new DatabaseConnection();
	 System.out.println("11111");
	 int x= db.regUser(u);
	 if(x>=1)
	  {
		 System.out.println("33333");
		 
		  request.setAttribute("sms","User registered successfully!!");
	  }
	  else
	  {
		  request.setAttribute("sms","user couldnot be registerd");
		  
	  }
	 
	 RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
	  rd.forward(request,response);
	}

}
