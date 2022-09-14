package com.capg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="flightid")
	int flightId;
	@Column(name ="source")
	String sourceLocation;
	@Column(name ="destination")
	String destinationLocation;
	@Column(name ="departure")
	String departureTime;
	@Column(name ="arrival")
	String arrivalTime;
	@Column(name ="traveldate")
	String date;
	@Column(name ="fare")
	double fare;
	//double duration;
	@Column(name ="availableseats")
	int availableSeats;
	public Flight(int flightId, String sourceLocation, String destinationLocation, String arrivalTime,
			String departureTime, String date, double fare, /*double duration,*/ int availableSeats) {
		super();
		this.flightId = flightId;
		this.sourceLocation = sourceLocation;
		this.destinationLocation = destinationLocation;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
		this.fare = fare;
		//this.duration = duration;
		this.availableSeats = availableSeats;
	}
	
	public Flight() {
		super();
	}

	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	public String getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	//@Column(name="travelDate")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	/*public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}*/
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", sourceLocation=" + sourceLocation + ", destinationLocation="
				+ destinationLocation + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", date="
				+ date + ", fare=" + fare + ", availableSeats=" + availableSeats + "]";
	}
	
	
}
