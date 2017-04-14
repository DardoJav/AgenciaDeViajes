package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Passenger {
	
	private Integer idPassenger;
	private String name;
	private String surname;
	private Integer dni;
	private String password;
	private Boolean enabled;
	private Set<Ticket> tickets = new HashSet<Ticket>();
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	public Passenger() {
	}
	
	public Passenger(String name, String surname, Integer dni, Set<Ticket> tickets, String password, Boolean enabled, Set<UserRole> userRoles) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.tickets = tickets;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}
	
	public Integer getIdPassenger() {
		return idPassenger;
	}
	public void setIdPassenger(Integer idPassenger) {
		this.idPassenger = idPassenger;
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
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}
