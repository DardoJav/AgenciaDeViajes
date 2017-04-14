package com.agenciaDeViajesMVC.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.agenciaDeViajesMVC.modelos.Airline;

public interface AirlineService {

	public List<Airline> listAirlines();

	void saveAirline(Airline airline) throws DataIntegrityViolationException;
	
	void updateAirline(Airline airline);
	
	void removeAirline(Integer id);
	
	Airline getAirlineById(int id);

}
