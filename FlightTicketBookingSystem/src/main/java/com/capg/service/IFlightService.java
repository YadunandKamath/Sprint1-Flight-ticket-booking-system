package com.capg.service;

import java.util.List;

import com.capg.entities.Flight;

public interface IFlightService {
	
	public List<Flight> getFlightDetails();
	public Flight getFlightDetailsById(int flightId);
	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public void deleteFlight(int flightId);

}
