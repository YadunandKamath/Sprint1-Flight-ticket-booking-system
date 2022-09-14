package com.capg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IBookingDAO;
import com.capg.entities.*;
import com.capg.exceptions.BookingAlreadyExistsException;
import com.capg.exceptions.BookingNotFoundException;
import com.capg.exceptions.FlightNotFoundException;
import com.capg.exceptions.UserNotFoundException;
import com.capg.dao.*;



@Service
public class BookingServiceImpl implements IBookingService{
	
	/*
	List<Booking> list = new ArrayList<>(Arrays.asList(
			new Booking(101, "01-01-2022", 30000.0, 3),
			new Booking(102, "02-02-2022", 25000.0, 2),
			new Booking(103, "03-03-2022", 45000.0, 3)
			)); 
	
	@Override
	public List<Booking> getBooking(){
		return list;
	}
	
	@Override
	public Booking getBookingById(int bookingId) {
		Booking booking = null;
		for(Booking b : list) {
			if(b.getBookingId()==bookingId) {
				booking = b;
				break;
			}
		}
		return booking;
	}
	
	@Override
	public Booking addBooking(Booking booking) {
		this.list.add(booking);
		return booking;
	}
	
	@Override
	public Booking updateBooking(Booking booking) {
		this.list.forEach(b -> 
		{
			if(b.getBookingId()==booking.getBookingId()) {
				b.setBookingDate(booking.getBookingDate());
				b.setTotalCost(booking.getTotalCost());
				b.setSeatsBooked(booking.getSeatsBooked());
			}
		});
		return booking;
	}

	@Override
	public void deleteBooking(int bookingId) {
		this.list = list.stream().filter(b->b.getBookingId()!=bookingId).collect(Collectors.toList());
	}
	
	*/
	
	@Autowired
	private IBookingDAO bookingdao;

	@Override
	public List<Booking> getBooking() {
		
		return bookingdao.findAll();
	}

	@Override
	public Booking addBooking(Booking booking) {
		if(bookingdao.existsById(booking.getBookingId())) {
			throw new BookingAlreadyExistsException();
		}
		bookingdao.save(booking);
		return booking;
	}

	@Override
	public Booking updateBooking(Booking booking) {
		if(bookingdao.findById(booking.getBookingId()).isEmpty()) {
			throw new BookingNotFoundException();
		}
		bookingdao.save(booking);
		return booking;
	}

	@Override
	public Booking getBookingById(int bookingId){
		// TODO Auto-generated method stub
		if(bookingdao.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		return bookingdao.findById(bookingId).get();
	}

	@Override
	public void deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		if(bookingdao.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		Booking b = bookingdao.getOne(bookingId);
		bookingdao.delete(b);
	}

	@Override
	public List<Booking> getBookingsByFlightId(int flightId) {
		// TODO Auto-generated method stub
		List<Booking> bookings = new ArrayList<>();
		for(Booking b : bookingdao.findAll())
		{
			if(b.getFlightId()==flightId)
			{	
				bookings.add(b);
			}
		}
		if(bookings.isEmpty()) throw new FlightNotFoundException();
		return bookings;
		
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Booking> bookings = new ArrayList<>();
		for(Booking b : bookingdao.findAll())
		{
			if(b.getUserId()==userId)
			{	
				bookings.add(b);
			}
		}
		if(bookings.isEmpty()) throw new UserNotFoundException();
		return bookings;
	}

}
