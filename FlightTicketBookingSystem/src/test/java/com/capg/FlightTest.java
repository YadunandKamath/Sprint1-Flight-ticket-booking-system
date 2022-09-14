package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dao.IFlightDAO;
import com.capg.dao.IUserDao;
import com.capg.entities.Flight;
import com.capg.entities.User;

@SpringBootTest
class FlightTest {
	@Autowired
	IFlightDAO flightDao;
	
	@Test
	void testInjection() {
		assertThat(flightDao).isNotNull();
	}
	
	@Test
	void testAddFlight() {
		Flight f=new Flight(1, "Bengaluru", "Goa", "05:00", "8:00", "01-02-22", 1550, 90);
		flightDao.save(f);
		assertEquals(flightDao.findById(001).get().toString(),f.toString());
	}
}
