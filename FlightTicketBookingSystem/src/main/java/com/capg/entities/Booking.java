package com.capg.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name="bookingid")
	private int bookingId;
	@Column(name="userid")
	private int userId;
	@Column(name="flightid")
	private int flightId;
	@Column(name="bookingdate")
	private String bookingDate;
	//private String travelDate;
	@Column(name="totalcost")
	private double totalCost;
	@Column(name="seatsbooked")
	private int seatsBooked;
	@OneToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private User user;
	@OneToOne
	@JoinColumn(name = "flightid", insertable = false, updatable = false)
	private Flight flight;
	
	
//	private List<Passenger> passengers;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingId, int userId, int flightId,String bookingDate, /*String travelDate, */double totalCost,
			int seatsBooked) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		//this.travelDate = travelDate;
		this.totalCost = totalCost;
		this.seatsBooked = seatsBooked;
	}

	
	//@Id
	//@Column(name="bookingid")
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	//@Column(name="bookingdate")
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	/*public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}*/

	//@Column(name="totalcost")
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	//@Column(name="seatsbooked")
	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	

	//@Column(name="userid")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//@Column(name="flightid")
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	//@OneToOne
	//@JoinColumn(name = "userid", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	//@OneToOne
	//@JoinColumn(name = "flightid", insertable = false, updatable = false)
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

//	@OneToMany(mappedBy = "booking")
//	public List<Passenger> getPassengers() {
//		return passengers;
//	}
//
//	public void setPassengers(List<Passenger> passengers) {
//		this.passengers = passengers;
//	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate +/* ", travelDate=" + travelDate 
				+ */", totalCost=" + totalCost + ", seatsBooked=" + seatsBooked + ", user=" + user + ", flight=" 
				+ flight + "]";
	}
	
	//List<Passenger> passengers = passengers.stream().filter(t->t.getBookingId()==bookingId).collect(Collectors.toList());
}
