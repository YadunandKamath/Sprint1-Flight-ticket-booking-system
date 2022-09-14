package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.service.IBookingService;
import com.capg.entities.*;
import com.capg.exceptions.BookingAlreadyExistsException;
import com.capg.exceptions.BookingNotFoundException;



@RestController
public class BookingController {
	@Autowired
	IBookingService service;
	
	@GetMapping("/booking")
	public List<Booking> getBooking(){
		return this.service.getBooking();
	}
	@GetMapping("/booking/{bookingId}")
	public Booking getEmployeeById(@PathVariable int bookingId) throws BookingNotFoundException{
		return this.service.getBookingById(bookingId);
	}
	@PostMapping("/booking")
	public Booking addBooking(@RequestBody Booking booking) throws BookingAlreadyExistsException{
		return this.service.addBooking(booking);
	}
	@PutMapping("/booking")
	public Booking updateEmployee(@RequestBody Booking booking) throws BookingNotFoundException{
		return this.service.updateBooking(booking);
	}
	@DeleteMapping("/booking/{bookingId}")
	public void deleteEmployee(@PathVariable int bookingId) throws BookingNotFoundException{
		
		this.service.deleteBooking(bookingId);
		
	}
	
	@GetMapping("/booking/flight/{flightId}")
	public List<Booking> getBookingsByFlightId(@PathVariable int flightId)
	{
		System.out.println("All bookings for flightId");
		return this.service.getBookingsByFlightId(flightId);
	}
	
	@GetMapping("/booking/user/{userId}")
	public List<Booking> getBookingsByUserId(@PathVariable int userId)
	{
		System.out.println("All bookings for flightId");
		return this.service.getBookingsByUserId(userId);
	}
}
