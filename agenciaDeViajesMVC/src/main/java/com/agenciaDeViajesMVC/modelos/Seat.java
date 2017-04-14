package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Seat {
	
	private Integer idSeat;
	private String position;
	private Plane plane;
	private Set<Ticket> tickets = new HashSet<Ticket>();
	
	public Seat() {
	}
	
	public Seat(String position, Plane plane, Set<Ticket> tickets) {
		this.position = position;
		this.plane = plane;
		this.tickets = tickets;
	}

	public Integer getIdSeat() {
		return idSeat;
	}
	public void setIdSeat(Integer idSeat) {
		this.idSeat = idSeat;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}	
	

}
