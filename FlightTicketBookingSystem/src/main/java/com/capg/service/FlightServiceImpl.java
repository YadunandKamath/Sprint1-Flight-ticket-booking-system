package com.capg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IFlightDAO;
import com.capg.entities.Flight;
import com.capg.exceptions.FlightAlreadyExistsException;
import com.capg.exceptions.FlightNotFoundException;

@Service
public class FlightServiceImpl implements IFlightService {

	@Autowired
	IFlightDAO flightDao;
	
	@Override
	public List<Flight> getFlightDetails() {
		return flightDao.findAll();
	}

	@Override
	public Flight getFlightDetailsById(int flightId) {
		if(flightDao.findById(flightId).isEmpty()) {
			throw new FlightNotFoundException();
		}
		return flightDao.findById(flightId).get();
	}

	@Override
	public Flight addFlight(Flight flight) {
		if(flightDao.existsById(flight.getFlightId())) {
			throw new FlightAlreadyExistsException();
		}
		flightDao.save(flight);
		return flight;
	}

	@Override
	public Flight updateFlight(Flight flight) {
		if(flightDao.findById(flight.getFlightId()).isEmpty()) {
			throw new FlightNotFoundException();
		}
		flightDao.save(flight);
		return flight;
	}

	@Override
	public void deleteFlight(int flightId) {
		if(flightDao.findById(flightId).isEmpty()) {
			throw new FlightNotFoundException();
		}
		Flight f = flightDao.findById(flightId).get();
		flightDao.delete(f);
		
	}
	
	/*
	List<Flight> list = new ArrayList<>(Arrays.asList(
			new Flight(1, "Bengaluru", "Goa", "05:00", "8:00", "01-02-22", 1550, 90),
			new Flight(2, "Chennai", "Hyderabad", "19:00", "23:00", "10-09-22", 2550, 120),
			new Flight(3, "Mumbai", "Gandhinagar", "09:00", "14:00", "19-05-22", 4500, 50)
			)); 
	
	@Override
	public List<Flight> getFlightDetails(){
		return list;
	}
	
	@Override
	public Flight getFlightDetailsById(int flightId) {
		Flight flight = null;
		for(Flight f : list) {
			if(f.getFlightId()==flightId) {
				flight = f;
				break;
			}
		}
		return flight;
	}
	
	@Override
	public Flight addFlight(Flight flight) {
		this.list.add(flight);
		return flight;
	}
	
	@Override
	public Flight updateFlight(Flight flight) {
		this.list.forEach(f -> 
		{
			if(f.getFlightId()==flight.getFlightId()) {
				f.setArrivalTime(flight.getArrivalTime());
				f.setAvailableSeats(flight.getAvailableSeats());
				f.setDate(flight.getDate());
				f.setDepartureTime(flight.getDepartureTime());
				f.setDestinationLocation(flight.getDestinationLocation());
				f.setFare(flight.getFare());
				f.setSourceLocation(flight.getSourceLocation());
			}
		});
		return flight;
	}

	@Override
	public void deleteFlight(int flightId) {
		this.list = list.stream().filter(f->f.getFlightId()!=flightId).collect(Collectors.toList());
	}
	*/
}
