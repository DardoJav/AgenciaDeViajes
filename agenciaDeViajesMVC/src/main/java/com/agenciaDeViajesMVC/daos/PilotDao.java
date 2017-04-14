package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Pilot;

/**
 * Interface of PilotDaoImpl
 * @author dardo.luna
 *
 */
public interface PilotDao {
	
	/**
	 * Save pilot in BD
	 * @param pilot to save inBD
	 */
	void savePilot(Pilot pilot);
	
	/**
	 * Update pilot in BD
	 * @param pilot to update in BD
	 */
	void updatePilot(Pilot pilot);
	
	/**
	 * Remove pilot in BD
	 * @param pilot to remove in BD
	 */
	void removePilot(Pilot pilot);
	
	/**
	 * Search and list pilots from DB
     * @return List of pilots from BD
	 */
	List<Pilot> getAllPilots();
}
