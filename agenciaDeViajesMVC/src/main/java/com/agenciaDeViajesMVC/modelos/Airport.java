package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Airport {
	
	private Integer idAirport;
	private String direction;
	private Integer phoneNumber;
	private String name;
	private City city;
	private Set<Flight> departureFlights = new HashSet<Flight>();
	private Set<Flight> arrivalFlights = new HashSet<Flight>();;
	
	public Airport() {
	}
	
	public Airport(String direction, Integer phoneNumber, String name, City city, Set<Flight> departureFlights, Set<Flight> arrivalFlights) {
		this.direction = direction;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.city = city;
		this.departureFlights = departureFlights;	
		this.arrivalFlights = arrivalFlights;	
	}
	
	public Integer getIdAirport() {
		return idAirport;
	}
	public void setIdAirport(Integer idAirport) {
		this.idAirport = idAirport;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Set<Flight> getDepartureFlights() {
		return departureFlights;
	}
	public void setDepartureFlights(Set<Flight> departureFlights) {
		this.departureFlights = departureFlights;
	}
	public Set<Flight> getArrivalFlights() {
		return arrivalFlights;
	}
	public void setArrivalFlights(Set<Flight> arrivalFlights) {
		this.arrivalFlights = arrivalFlights;
	}

}
