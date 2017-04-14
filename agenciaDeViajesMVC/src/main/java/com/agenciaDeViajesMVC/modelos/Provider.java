package com.agenciaDeViajesMVC.modelos;

import java.util.HashSet;
import java.util.Set;

public class Provider {
	
	private Integer idProvider;
	private String name;
	private String direction;
	private Set<Plane> planes = new HashSet<Plane>();
	
	public Provider() {
	}
	
	public Provider (String name, String direction, Set<Plane> planes) {
		this.name = name;
		this.direction = direction;
		this.planes = planes;
	}
	
	public Integer getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Set<Plane> getPlanes() {
		return planes;
	}
	public void setPlanes(Set<Plane> planes) {
		this.planes = planes;
	}

}
