package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Pilot {
	
	private Integer idPilot;
	private Integer dni;
	private String name;
	private String surname;
	private Integer regNumber;
	
	private Set<Flight> flights = new HashSet<Flight>();
	
//	relacion muchos a muchos con lineaAerea
	private Set<Airline> airlines = new HashSet<Airline>();
	
	public Pilot() {
	}
	
	public Pilot(Integer dni, String name, String surname, Integer regNumber, Set<Flight> flights, Set<Airline> airlines) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.regNumber = regNumber;
		this.flights = flights;
		this.airlines = airlines;
	}
	
	public Integer getIdPilot() {
		return idPilot;
	}
	public void setIdPilot(Integer idPilot) {
		this.idPilot = idPilot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(Integer regNumber) {
		this.regNumber = regNumber;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	public Set<Airline> getAirlines() {
		return airlines;
	}
	public void setAirlines(Set<Airline> airlines) {
		this.airlines = airlines;
	}

}
