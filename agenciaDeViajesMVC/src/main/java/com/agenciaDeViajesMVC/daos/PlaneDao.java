package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Plane;

/**
 * Interfaz de AvionDaoImpl
 * @author dardo.luna
 *
 */
public interface PlaneDao {

	/**
	 * Save plane in BD
	 * @param plane to save in BD
	 */
	void savePlane(Plane plane);
	
	/**
	 * Update plane in BD
	 * @param plane to update in BD
	 */
	void updatePlane(Plane plane);
	
	/**
	 * Remove plane in BD
	 * @param plane to remove in BD
	 */
	void removePlane(Plane plane);
	
	/**
	 * Search and return list of planes from BD
     * @return List of planes from BD
	 */
	List<Plane> getAllPlanes();
}
