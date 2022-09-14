package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Passenger;

@Repository
public interface IPassengerDAO extends JpaRepository<Passenger, Integer>{

}
