package com.airline.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.model.Flight;
import com.airline.model.User;

public class DatabaseConnection 
{
Connection con =null;
	
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_booking?user=root&password=Mysqlpass2774@");
			 System.out.println("Connection done");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public boolean verify(User u) {
		boolean isValid= false;
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				isValid = true;
			}
			else
			{
				isValid= false;
			}
		} catch (Exception e) {
			System.out.println("Error in sql Statement" +e);
		}
		return isValid;
		
	}
	public int regUser(User u) {
		int x = 0;
		try {
			System.out.println("22222222");
			
			PreparedStatement pst=con.prepareStatement("insert into users(username,password,email,role) values(?,?,?,?) ");
    		pst.setString(1,u.getUsername());
    		pst.setString(2,u.getPassword());
    		pst.setString(3,u.getEmail());
    		pst.setString(4,u.getRole());
    		x=pst.executeUpdate();
			System.out.println("123123");
		    x = pst.executeUpdate();
			
		}
		catch(Exception e){
			System.out.println("Error in sql Statement" +e);
		}
		return x;
	}
	public ArrayList<Flight> getAllFlightsList() {
		ArrayList<Flight> f= new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement("Select * from flights");
					ResultSet rs =ps.executeQuery();
			while (rs.next()) {
                Flight f1 = new Flight();
                f1.setId(rs.getInt("id"));
                f1.setFlightNumber(rs.getString("flight_number"));
                f1.setDeparture(rs.getString("departure"));
                f1.setArrival(rs.getString("arrival"));
                f1.setFlight_date(rs.getString("flight_date"));
                f1.setCapacity(rs.getInt("capacity"));
                f1.setDeparture_time(rs.getString("departure_time"));
                f1.setArrival_time(rs.getString("arrival_time"));
                f1.setPrice(rs.getDouble("price"));
                f.add(f1);
            
		}
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error in sql Statement" +e);
		}
		return f;
	}
	
	 public ArrayList<Flight> getFlights() {
	        ArrayList<Flight> flights = new ArrayList<>();
	        try {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM flights");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Flight flight = new Flight();
	                flight.setId(rs.getInt("id"));
	                flight.setFlightNumber(rs.getString("flight_number"));
	                flight.setDeparture(rs.getString("departure"));
	                flight.setArrival(rs.getString("arrival"));
	                flight.setFlight_date(rs.getString("flight_date"));
	                flight.setCapacity(rs.getInt("capacity"));
	                flight.setPrice(rs.getDouble("price"));
	                flight.setDeparture_time(rs.getString("departure_time"));
	                flight.setArrival_time(rs.getString("arrival_time"));
	                flights.add(flight);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return flights;
	    }
	 
	 
	 public Flight getFlightByNumber(String flightNumber) {
	        Flight flight = null;
	        try {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM flights WHERE flight_number = ?");
	            ps.setString(1, flightNumber);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                flight = new Flight();
	                flight.setId(rs.getInt("id"));
	                flight.setFlightNumber(rs.getString("flight_number"));
	                flight.setDeparture(rs.getString("departure"));
	                flight.setArrival(rs.getString("arrival"));
	                flight.setFlight_date(rs.getString("flight_date"));
	                flight.setCapacity(rs.getInt("capacity"));
	                flight.setPrice(rs.getDouble("price"));
	                flight.setDeparture_time(rs.getString("departure_time"));
	                flight.setArrival_time(rs.getString("arrival_time"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return flight;
	    }
		
	 public boolean addFlight(Flight flight) throws SQLException {
	        String sql = "INSERT INTO flights (flight_number, departure, arrival, price, capacity,departure_time, arrival_time,flight_date) VALUES (?, ?, ?, ?, ?,?,?, ? )";
	        
	        try (
	             PreparedStatement pst = con.prepareStatement(sql)) {
	             
	            pst.setString(1, flight.getFlightNumber());
	            pst.setString(2, flight.getDeparture());
	            pst.setString(3, flight.getArrival());
	            pst.setDouble(4, flight.getPrice());
	            pst.setInt(5, flight.getCapacity());
	            pst.setString(6,flight.getDeparture_time());
	            pst.setString(7, flight.getArrival_time());
	            pst.setString(8, flight.getFlight_date());

	            int rowsAffected = pst.executeUpdate();
	            return rowsAffected > 0;
	        }
	    }
	 
	 public boolean removeFlight(String flightNumber) throws SQLException {
	        String sql = "DELETE FROM flights WHERE flight_number=?";
	        
	        int rowsAffected=0;
	        
	        try 
	     {
	        	PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, flightNumber);

	            rowsAffected = pst.executeUpdate();
	            
	        }
	        catch (Exception e) {
				// TODO: handle exception
			}
	        
			return rowsAffected > 0;
	    }
	 
	 
	 public boolean updateFlight(Flight flight) {
	        boolean isUpdated = false;
	        try {
	            PreparedStatement ps = con.prepareStatement("UPDATE flights SET flight_number = ?, departure = ?, arrival = ?, flight_date = ?, capacity = ?, price = ?, departure_time = ?, arrival_time = ? WHERE id = ?");
	            ps.setString(1, flight.getFlightNumber());
	            ps.setString(2, flight.getDeparture());
	            ps.setString(3, flight.getArrival());
	            ps.setString(4, flight.getFlight_date());
	            ps.setInt(5, flight.getCapacity());
	            ps.setDouble(6, flight.getPrice());
	            ps.setString(7, flight.getDeparture_time());
	            ps.setString(8, flight.getArrival_time());
	            ps.setInt(9, flight.getId());
	            int rowsAffected = ps.executeUpdate();
	            isUpdated = rowsAffected > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isUpdated;
	    }
	 
	 public Flight modifyFlight(String flightNumber)
		{
			Flight f=new Flight();
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from flights WHERE flight_number=?");
				ps.setString(1,flightNumber);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					 f.setFlightNumber(rs.getString("flight_number"));
					f.setDeparture(rs.getString("departure"));
					f.setArrival(rs.getString("arrival"));
					f.setCapacity(rs.getInt("capacity"));
					f.setPrice(rs.getDouble("price"));
					f.setDeparture_time(rs.getString("departure_time"));
					f.setArrival_time(rs.getString("arrival_time"));
					f.setFlight_date(rs.getString("flight_date"));
				}
			}
			catch (Exception e) 
			{
				
			}
		return f;
		}
	 
	 
	 public ArrayList<Flight> searchFlights(String departure, String arrival) {
	        ArrayList<Flight> flights = new ArrayList<>();
	        
	         
	            String query = "SELECT * FROM flights WHERE departure = ? AND arrival = ?";
	            try  {
	            	
	            	PreparedStatement pstmt = con.prepareStatement(query);
	                pstmt.setString(1, departure);
	                pstmt.setString(2, arrival);
	                ResultSet rs = pstmt.executeQuery();
	                while (rs.next()) {
	                    Flight flight = new Flight();
	                    flight.setFlightNumber(rs.getString("flight_number"));
                        flight.setDeparture(rs.getString("departure"));
                        flight.setArrival(rs.getString("arrival"));
                        flight.setDeparture_time(rs.getString("departure_time"));
                        flight.setArrival_time(rs.getString("arrival_time"));
                        flight.setCapacity(rs.getInt("capacity"));
                        flight.setFlight_date(rs.getString("flight_date"));
                        flight.setPrice(rs.getDouble("price"));
                        
                        flights.add(flight);	                    	            
	                }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        
	        }
	            return flights;
	    }

	      
	 public boolean processPayment(String upiOption, String upiId, String flightNumber, String departure, String arrival, 
             String departureTime, String arrivalTime, String flightDate, String passengerName, String email) {
boolean isPaymentSuccessful = false;

// Implement your payment processing logic here
// For now, we'll just simulate a successful payment
try {
String query = "INSERT INTO bookings (upi_option, upi_id, flight_number, departure, arrival, departure_time, arrival_time, flight_date, passenger_name, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1, upiOption);
ps.setString(2, upiId);
ps.setString(3, flightNumber);
ps.setString(4, departure);
ps.setString(5, arrival);
ps.setString(6, departureTime);
ps.setString(7, arrivalTime);
ps.setString(8, flightDate);
ps.setString(9, passengerName);
ps.setString(10, email);

int result = ps.executeUpdate();
if (result > 0) {
isPaymentSuccessful = true;
}
} catch (SQLException e) {
e.printStackTrace();
}

return isPaymentSuccessful;
}

	    }
	
	
	
	

