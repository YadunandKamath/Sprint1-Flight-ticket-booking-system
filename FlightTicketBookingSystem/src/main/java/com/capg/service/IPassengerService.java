package com.capg.service;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.capg.entities.Passenger;


public interface IPassengerService {
	public List<Passenger> getPassengers();
	public Passenger getPassengerById(int passengerId);
	public Passenger addPassenger(Passenger passenger);
	public Passenger updatePassenger(Passenger passenger);
	public void deletePassenger(int passengerId);
	public List<Passenger> getPassengersByBookingId(int bookingId);

}
