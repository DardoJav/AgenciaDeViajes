package com.agenciaDeViajesMVC.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.agenciaDeViajesMVC.modelos.Airline;

/**
 * Interface of AirlineDaoImpl
 * @author dardo.luna
 *
 */
public interface AirlineDao {

	/**
	 * Save airline in BD
	 * @param airline to save in BD
	 */
	void saveAirline(Airline airline);
	
	/**
	 * Update airline in BD
	 * @param airline to update in BD
	 */
	void updateAirline(Airline airline);
	
	/**
	 * Remove airline in BD
	 * @param id for airline to remove in BD
	 */
	void removeAirline(Integer id);
	
	/**
	 * Search and return list of airlines form BD
     * @return List of airlines from BD
	 */
	List<Airline> getAllAirlines();
	
	Airline getAirlineById(int id);
	
}
