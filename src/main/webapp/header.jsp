<%@page import="com.airline.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SKY PALATTE</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/script.js"></script>
   
<body style="background:url(images/image3.jpg);
        background-size:100%;
        
    background-repeat: no-repeat; 
">
    <header>
        <div class="logo">
            <img src="images/airplane-icon.png" alt="Icon">
            <span>SKY Palette Airlines</span>
        </div>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="searchFlights.jsp">Flights</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
        <div class="user-greeting">
        
            <br><br>
            <div><h3>Welcome</h3>
            <%
            String username=(String)session.getAttribute("username");
            if(username!=null)
            {
           	 
                %>
            	
            	 <% 
            	 out.print(username);
             }
            %>
            </div>
        </div>
    </header>
    
    <main>
       
     