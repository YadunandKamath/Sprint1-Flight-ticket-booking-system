package com.capg.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.entities.*;

public interface IBookingService {
	public List<Booking> getBooking();
	public Booking getBookingById(int bookingId);
	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public void deleteBooking(int bookingId);
	public List<Booking> getBookingsByFlightId(int flightId);
	public List<Booking> getBookingsByUserId(int userId);
}
