package com.agenciaDeViajesMVC.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agenciaDeViajesMVC.daos.SeatDao;
import com.agenciaDeViajesMVC.daos.PlaneDao;
import com.agenciaDeViajesMVC.daos.ProviderDao;
import com.agenciaDeViajesMVC.modelos.Seat;
import com.agenciaDeViajesMVC.modelos.Plane;
import com.agenciaDeViajesMVC.modelos.Provider;

/**
 * Tests for AsientoDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class AsientoDaoTest {
	
	@Inject
	private PlaneDao planeDao;

	@Inject
	private SeatDao seatDao;
	
	@Inject
	private ProviderDao providerDao;

	/**
	 * Test guardado de Asiento en BD exitoso
	 */
	@Test
	public void saveAsientoSuccessfullTest() {
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		planeDao.saveAvion(plane);
		
		Seat asiento = nuevoAsiento(plane);
		Set<Seat> asientos = new HashSet<Seat>(Arrays.asList(asiento));
		plane.setAsientos(asientos);		
		seatDao.saveAsiento(asiento);
		
		List<Seat> asientos2 = seatDao.getAllAsientos();
		
		Assert.assertEquals(asientos2.get(0).getPosicion(),"1A");
		
		seatDao.removeAsiento(asientos2.get(0));
//		avionDao.removeAvion(avion);
		providerDao.removeProveedor(provider);
	}
	
	/**
	 * Test actualizacion de Asiento en BD exitoso
	 */
	@Test
	public void editAsientoSuccessfullTest() {
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		planeDao.saveAvion(plane);
		
		Seat asiento = nuevoAsiento(plane);
		Set<Seat> asientos = new HashSet<Seat>(Arrays.asList(asiento));
		plane.setAsientos(asientos);
		seatDao.saveAsiento(asiento);
		
		List<Seat> asientos2 = seatDao.getAllAsientos();
		asientos2.get(0).setPosicion("4D");
		seatDao.updateAsiento(asientos2.get(0));
		List<Seat> asientos3 = seatDao.getAllAsientos();
		
		Assert.assertEquals(asientos3.get(0).getPosicion(),"4D");
		
		seatDao.removeAsiento(asientos3.get(0));
//		avionDao.removeAvion(avion);
		providerDao.removeProveedor(provider);
	}
	
	/**
	 * Test borrado de Aeropuerto en BD exitoso
	 */
	@Test
	public void removeAsientoSuccessfullTest() {
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		planeDao.saveAvion(plane);
		
		Seat asiento = nuevoAsiento(plane);
		Set<Seat> asientos = new HashSet<Seat>(Arrays.asList(asiento));
		plane.setAsientos(asientos);
		seatDao.saveAsiento(asiento);
		
		List<Seat> asientos2 = seatDao.getAllAsientos();
		seatDao.removeAsiento(asientos2.get(0));
		List<Seat> asientos3 = seatDao.getAllAsientos();

		Assert.assertEquals(asientos3.size(),0);
		
//		avionDao.removeAvion(avion);
		providerDao.removeProveedor(provider);
	}
	
	/**
	 * Crea Ciudad
	 * @return Ciudad
	 */
	private Provider nuevoProveedor(){
		Provider provider = new Provider();
		provider.setNombre("SRS");
		provider.setDireccion("Avellaneda 2455");
		return provider;
	}
	
	/**
	 * Crea Avion que contendra Asiento
	 * @return Avion que contendra Asiento
	 */
	private Plane nuevoAvion(Provider provider){
		Plane plane = new Plane();
		plane.setModelo("AB123");
		plane.setNroSerie(1234);
		plane.setHorasVoladas(0);
		plane.setColor("blanco");
		plane.setProveedor(provider);
		return plane;
	}
	
	/**
	 * Crea Asiento correspondiente al avion dado como parametro
	 * @param plane Avion que contendra Asiento
	 * @return Asiento correspondiente al avion dado como parametro
	 */
	private Seat nuevoAsiento(Plane plane){
		Seat asiento = new Seat();
		asiento.setAvion(plane);
		asiento.setPosicion("1A");
		return asiento;
	}
}
