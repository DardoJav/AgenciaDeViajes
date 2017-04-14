package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Ticket;

/**
 * Interface of TicketDaoImpl
 * @author dardo.luna
 *
 */
public interface TicketDao {

	/**
	 * Save ticket in BD
	 * @param ticket to save in BD
	 */
	void saveTicket(Ticket ticket);
	
	/**
	 * Update ticket in BD
	 * @param ticket to update in BD
	 */
	void updateTicket(Ticket ticket);
	
	/**
	 * Remove ticket in BD
	 * @param ticket to remove in BD
	 */
	void removeTicket(Ticket ticket);
	
	/**
	 * Search and list tickets from BD
     * @return List of tickets from BD
	 */
	List<Ticket> getAllTickets();
}
