package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Plane {
	
	private Integer idPlane;
	private String model;
	private Integer serialNumber;
	private Integer hoursFlown;
	private String color;
	private Provider provider;
	private Airline airline;

	private Set<Flight> flights = new HashSet<Flight>();
	private Set<Seat> seats = new HashSet<Seat>();
	
	public Plane() {
	}
	
	public Plane(String model, Integer serialNumber, Integer hoursFlown, String color, Provider provider, Set<Flight> flights, Set<Seat> seats) {
		this.model = model;
		this.serialNumber = serialNumber;
		this.hoursFlown = hoursFlown;
		this.color = color;
		this.provider = provider;
		this.flights = flights;
		this.seats = seats;
	}
	
	public Integer getIdPlane() {
		return idPlane;
	}
	public void setIdPlane(Integer idPlane) {
		this.idPlane = idPlane;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getHoursFlown() {
		return hoursFlown;
	}
	public void setHoursFlown(Integer hoursFlown) {
		this.hoursFlown = hoursFlown;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	public Set<Seat> getSeats() {
		return seats;
	}
	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
}
