package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FlightTicketBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTicketBookingSystemApplication.class, args);
		System.out.println("Hi SpringBoot");
	}

}
