package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Passenger;

/**
 * Interface of PassengerDaoImpl
 * @author dardo.luna
 *
 */
public interface PassengerDao {

	/**
	 * Save passenger in BD
	 * @param passenger to save in BD
	 */
	void savePassenger(Passenger passenger);
	
	/**
	 * Update passenger in BD
	 * @param passenger to update in BD
	 */
	void updatePassenger(Passenger passenger);
	
	/**
	 * Remove passenger in BD
	 * @param passenger to remove in BD
	 */
	void removePassenger(Passenger passenger);
	
	/**
	 * Search and return list of passenger from DB
     * @return List of passenger from BD
	 */
	List<Passenger> getAllPassengers();

	/**
	 * Find Passenger by name
	 * @param name of the passenger
	 * @return passenger
	 */
	Passenger findPassengerByName(String name);
	
}
