package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Airport;

/**
 * Interface of AirportDaoImpl
 * @author dardo.luna
 *
 */
public interface AirportDao {

	/**
	 * Save Airport in BD
	 * @param aeropuerto Aeropuerto a guardar en BD
	 */
	void saveAirport(Airport airport);
	
	/**
	 * Update Airport in BD
	 * @param airport to update in BD
	 */
	void updateAirport(Airport airport);
	
	/**
	 * Remove Airport from BD
	 * @param airport to remove from BD
	 */
	void removeAirport(Airport airport);
    
	/**
	 * Search and return List of airports from BD
     * @return List of airports from BD
     */
    List<Airport> getAllAirports();
}
