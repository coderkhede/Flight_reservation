<%@page import="java.util.ArrayList"%>
<%@page import="com.airline.model.Flight"%>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="css/editFlightCSS.css">

<section class="edit-flight-form">
    <h2>Edit Flight</h2>
    Select Flight Number To Search Flight Details:
    <form action="getFlightServlet" method="post">
         
        <select name="flightNumber">
            <%
                ArrayList al = (ArrayList) request.getAttribute("alF");
           System.out.println("al = "+al);
                if (al!= null) 
                {
                
                    for (int i=0; i<al.size(); i++) 
                    {
                    	Flight f = (Flight)al.get(i);
            %>
                        <option value="<%=f.getFlightNumber()%>"><%=f.getFlightNumber()%></option>
            <%
                    }
                }
            %>
        </select>
        <br>
        <button type="submit" name="searchFlight" value="Search">Search Flight</button>
    </form>
    <a href="home.jsp">Back To Home Page</a>
</section>

<%@ include file="footer.jsp" %>
