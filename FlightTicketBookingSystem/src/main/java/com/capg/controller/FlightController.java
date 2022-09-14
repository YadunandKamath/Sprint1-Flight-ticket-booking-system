package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entities.Flight;
import com.capg.exceptions.FlightAlreadyExistsException;
import com.capg.exceptions.FlightNotFoundException;
import com.capg.service.IFlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	IFlightService flightService;
	
	@GetMapping("/flights")
	public List<Flight> getFlightDetails(){
		return this.flightService.getFlightDetails();		
	}
	
	@GetMapping("/flights/{flightid}")
	public Flight getFlightDetailsById(@PathVariable("flightid") int flightid) throws FlightNotFoundException{
		return this.flightService.getFlightDetailsById(flightid);		
	}
	
	@PostMapping("/flights")
	public Flight addFlightDetails(@RequestBody Flight flight) throws FlightAlreadyExistsException{
		return this.flightService.addFlight(flight);
	}
	
	@PutMapping("/flights")
	public Flight updateFlightDetails(@RequestBody Flight flight) throws FlightNotFoundException{
		return this.flightService.updateFlight(flight);
	}
	
	@DeleteMapping("/flights/{flightid}")
	public void deleteFlightDetails(@PathVariable("flightid") int flightid) throws FlightNotFoundException{
		this.flightService.deleteFlight(flightid);
	}
}