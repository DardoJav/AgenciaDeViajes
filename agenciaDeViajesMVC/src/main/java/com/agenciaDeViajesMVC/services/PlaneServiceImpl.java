package com.agenciaDeViajesMVC.services;

import java.util.List;

import com.agenciaDeViajesMVC.daos.PlaneDao;
import com.agenciaDeViajesMVC.modelos.Plane;

public class PlaneServiceImpl implements PlaneService{

private PlaneDao planeDao;
	
	public List<Plane> listPlanes(){
		return (List<Plane>) planeDao.getAllPlanes();
	}

	public PlaneDao getPlaneDao() {
		return planeDao;
	}

	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}
	
}
