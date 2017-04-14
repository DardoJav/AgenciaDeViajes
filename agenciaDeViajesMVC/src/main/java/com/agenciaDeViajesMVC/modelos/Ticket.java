package com.agenciaDeViajesMVC.modelos;

public class Ticket {
	
	private Integer idTicket;
	private Passenger passenger;
	private Flight flight;
	private Seat seat;
	
	public Ticket() {
	}
	
	public Ticket(Passenger passenger, Flight flight, Seat seat) {
		this.passenger = passenger;
		this.flight = flight;
		this.seat = seat;
	}
	
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	

}
