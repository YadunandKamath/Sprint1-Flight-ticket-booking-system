package com.capg.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IPassengerDAO;
import com.capg.entities.Passenger;
import com.capg.exceptions.BookingNotFoundException;
import com.capg.exceptions.PassengerAlreadyExistsException;
import com.capg.exceptions.PassengerNotFoundException;

@Service
public class PassengerServiceImpl implements IPassengerService{

	
	@Autowired
	IPassengerDAO passengerDao;
	
	
	@Override
	public List<Passenger> getPassengers() {
		// TODO Auto-generated method stub
		return passengerDao.findAll();
	}

	@Override
	public Passenger getPassengerById(int passengerId) {
		// TODO Auto-generated method stub
		if(passengerDao.findById(passengerId).isEmpty()) {
			throw new PassengerNotFoundException();
		}
		return passengerDao.findById(passengerId).get();
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		if(passengerDao.existsById(passenger.getPassengerId())) {
			throw new PassengerAlreadyExistsException();
		}
		passengerDao.save(passenger);
		return passenger;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		passengerDao.save(passenger);
		return passenger;
	}

	@Override
	public void deletePassenger(int passengerId) {
		// TODO Auto-generated method stub
		if(passengerDao.findById(passengerId).isEmpty()) {
			throw new PassengerNotFoundException();
		}
		Passenger p = passengerDao.getOne(passengerId);
		passengerDao.delete(p);
		
	}

	@Override
	public List<Passenger> getPassengersByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		List<Passenger> passengers = new ArrayList<>();
		for(Passenger p : passengerDao.findAll())
		{
			if(p.getBookingId()==bookingId)
			{	
				passengers.add(p);
			}
		}
		if(passengers.isEmpty()) throw new BookingNotFoundException();
		return passengers;
	}
	
	/*
	List<Passenger> lst;
	public PassengerServiceImpl()
	{
		lst = new ArrayList<Passenger>();
		lst.add(new Passenger(1001,"Rachanaa", "Raghuthama",22,"F","123gh45678",25));
		lst.add(new Passenger(1002,"Rakshita", "Raghuthama",17,"F","987ik4216",26));
	}

	@Override
	public List<Passenger> getPassengers() {
		// TODO Auto-generated method stub
		return lst;
	}

	@Override
	public Passenger getPassengerById(int passengerId) {
		// TODO Auto-generated method stub
		Passenger passenger = null;
		for(Passenger p:lst)
		{
			if(p.getPassangerId()==passengerId)
			{
				passenger=p;
				break;
			}
		}
		return passenger;
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		lst.add(passenger);
		return passenger;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		lst.forEach(t->{if(t.getPassangerId()==passenger.getPassangerId()) {
			//t.setBookingId(passenger.getBookingId());
			t.setFirstName(passenger.getFirstName());
			t.setLastName(passenger.getLastName());
			t.setAge(passenger.getAge());
			t.setGender(passenger.getGender());
			t.setPassportNumber(passenger.getPassportNumber());
			t.setSeatNumber(passenger.getSeatNumber());
		}
			});
			
		return passenger;
	}

	@Override
	public void deletePassenger(int passengerId) {
		// TODO Auto-generated method stub
		lst=lst.stream().filter(t->t.getPassangerId()!=passengerId).collect(Collectors.toList());
		
	}
	
	*/
	
}
