package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class City {
	
	private Integer idCity;
	private String name;
	private Integer postalCode;
//	relacion uno a muchos con Aeropuerto
	private Set<Airport> airports = new HashSet<Airport>();
	
	public City() {
	}
	
	public City(String name, Integer postalCode, Set<Airport> airports) {
		this.name = name;
		this.postalCode = postalCode;
		this.airports = airports;
	}
	
	public Integer getIdCity() {
		return idCity;
	}
	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public Set<Airport> getAirports() {
		return airports;
	}
	public void setAirports(Set<Airport> airports) {
		this.airports = airports;
	}
	
	

}
