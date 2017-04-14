package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.City;

/**
 * Interface of CityDaoImpl
 * @author dardo.luna
 *
 */
public interface CityDao {

	/**
	 * Save city in BD
	 * @param city to save in BD
	 */
	void saveCity(City city);
	
	/**
	 * Update city in BD
	 * @param city to update in BD
	 */
	void updateCity(City city);
	
	/**
	 * Remove city in BD
	 * @param city to remove in BD
	 */
	void removeCity(City city);
	
	/**
	 * Search and return list of cities from BD
     * @return List of cities from BD
	 */
	List<City> getAllCities();
}
