package com.agenciaDeViajesMVC.modelos;

public class UserRole {

	private Integer idUserRole;
	private Passenger passenger;
	private String role;
	
	public Integer getIdUserRole() {
		return idUserRole;
	}
	public void setIdUserRole(Integer idUserRole) {
		this.idUserRole = idUserRole;
	}
	public Passenger getPasajero() {
		return passenger;
	}
	public void setPasajero(Passenger passenger) {
		this.passenger = passenger;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
