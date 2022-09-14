package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Flight;

@Repository
public interface IFlightDAO extends JpaRepository<Flight, Integer>{

}
