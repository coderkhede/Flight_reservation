package com.airline.model;

public class Flight {
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", departure=" + departure + ", arrival="
				+ arrival + ", capacity=" + capacity + ", price=" + price + ", departure_time=" + departure_time
				+ ", arrival_time=" + arrival_time + ", flight_date=" + flight_date + "]";
	}
	private int id;
	private String flightNumber;
	private String departure;
    private String arrival;
    private int capacity;
    private double  price;
    private String departure_time;
    private String arrival_time;
    private String flight_date;
    
    
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public String setArrival_time(String arrival_time) {
		return this.arrival_time = arrival_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void add(Flight f1) {
		// TODO Auto-generated method stub
		
	}
	public String getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}

}
