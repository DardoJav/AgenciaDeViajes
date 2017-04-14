package com.agenciaDeViajesMVC.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Flight {

	private Integer idFlight;
	private Date arrivalDate;
	private Date departureDate;
	private Integer flightNumber;
//	Aerop llegada y destino son las claves foraneas de id aeropuerto
	private Airport airportOrigin;
	private Airport airportDestiny;
//	Clave Foranea a Piloto
	private Pilot pilot;
//	Clave Foranea a LineaAerea
	private Airline airline;
//	Clave Foranea a avion
	private Plane plane;
	
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public Flight() {
	}
	
	public Flight(Date arrivalDate, Date departureDate, Integer flightNumber, Airport airportOrigin, Airport airportDestiny, Pilot pilot, Airline airline, Plane plane, Set<Ticket> tickets) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.flightNumber = flightNumber;
		this.airportOrigin = airportOrigin;
		this.airportDestiny = airportDestiny;
		this.pilot = pilot;
		this.airline = airline;
		this.plane = plane;
		this.tickets = tickets;
	}
	
//	relacion muchos a muchos con pasajero y asiento
//	private Set<Pasajero> pasajeros = new HashSet<Pasajero>(0);
//	private Set<Asiento> asientos = new HashSet<Asiento>(0);

	public Integer getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Airport getAirportOrigin() {
		return airportOrigin;
	}
	public void setAirportOrigin(Airport airportOrigin) {
		this.airportOrigin = airportOrigin;
	}
	public Airport getAirportDestiny() {
		return airportDestiny;
	}
	public void setAirportDestiny(Airport airportDestiny) {
		this.airportDestiny = airportDestiny;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
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
