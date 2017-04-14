package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Airline {
	
	private Integer idAirline;
	private String name;
	
	private Set<Pilot> pilots = new HashSet<Pilot>();
	private Set<Flight> flights = new HashSet<Flight>();
	private Set<Plane> planes = new HashSet<Plane>();
	
	public Airline() {
	}
	
	public Airline(String name, Set<Pilot> pilots, Set<Flight> flights, Set<Plane> planes) {
		this.name = name;
		this.pilots = pilots;
		this.flights = flights;
		this.planes = planes;
	}
	
	public Integer getIdAirline() {
		return idAirline;
	}
	public void setIdAirline(Integer idAirline) {
		this.idAirline = idAirline;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Pilot> getPilots() {
		return pilots;
	}
	public void setPilots(Set<Pilot> pilots) {
		this.pilots = pilots;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	public Set<Plane> getPlanes() {
		return planes;
	}
	public void setPlanes(Set<Plane> planes) {
		this.planes = planes;
	}

}
