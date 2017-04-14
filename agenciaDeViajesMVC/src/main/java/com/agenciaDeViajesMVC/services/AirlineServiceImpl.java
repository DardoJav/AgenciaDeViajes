package com.agenciaDeViajesMVC.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.agenciaDeViajesMVC.daos.AirlineDao;
import com.agenciaDeViajesMVC.modelos.Airline;

public class AirlineServiceImpl implements AirlineService{

	private AirlineDao airlineDao;
	
	public List<Airline> listAirlines(){
		return (List<Airline>) airlineDao.getAllAirlines();
	}
	
	public void saveAirline(Airline airline) throws DataIntegrityViolationException{
		airlineDao.saveAirline(airline);
	}	
	
	public void removeAirline(Integer id){
		airlineDao.removeAirline(id);
	}
	
	public Airline getAirlineById(int id){
		return airlineDao.getAirlineById(id);
	}
	
	public void updateAirline(Airline airline){
		airlineDao.updateAirline(airline);
	}

	public AirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(AirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}
	
}
