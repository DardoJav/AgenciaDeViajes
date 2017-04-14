package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Seat;

/**
 * Interface of SeatDaoImpl
 * @author dardo.luna
 *
 */
public interface SeatDao {
	
	/**
	 * Save seat in BD
	 * @param seat to save in BD
	 */
	void saveSeat(Seat seat);
	
	/**
	 * Update seat in BD
	 * @param seat to update in BD
	 */
	void updateSeat(Seat seat);
	
	/**
	 * Remove seat in BD
	 * @param seat to remove in BD
	 */
	void removeSeat(Seat seat);
	
	/**
	 * Search and return list of seats from BD
     * @return List of seats from BD
	 */
	List<Seat> getAllSeats();

}
