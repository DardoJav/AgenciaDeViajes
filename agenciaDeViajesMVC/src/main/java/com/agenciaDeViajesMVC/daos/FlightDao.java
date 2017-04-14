package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Flight;

/**
 * Interface of FlightDaoImpl
 * @author dardo.luna
 *
 */
public interface FlightDao {

	/**
	 * Save flight in BD
	 * @param flight to save in BD
	 */
	void saveFlight(Flight flight);
	
	/**
	 * Update flight in DB
	 * @param flight to update in BD
	 */
	void updateFlight(Flight flight);
	
	/**
	 * Remove flight in DB
	 * @param flight to remove in BD
	 */
	void removeFlight(Flight flight);
	
	/**
	 * Search and return list of flights from BD
     * @return List of flights from BD
	 */
	List<Flight> getAllFlights();
}
