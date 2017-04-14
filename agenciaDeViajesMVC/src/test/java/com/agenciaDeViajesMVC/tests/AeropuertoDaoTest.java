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

import com.agenciaDeViajesMVC.daos.AirportDao;
import com.agenciaDeViajesMVC.daos.CityDao;
import com.agenciaDeViajesMVC.modelos.Airport;
import com.agenciaDeViajesMVC.modelos.City;


/**
 * Tests de AeropuertoDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class AeropuertoDaoTest {

	@Inject
	private AirportDao airportDao;

	@Inject
	private CityDao cityDao;
	
	/**
	 * Test guardado de Aeropuerto en BD exitoso
	 */
	@Test
	public void saveAeropuertoSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
		cityDao.saveCiudad(ciudad);
		Airport aeropuerto = nuevoAeropuerto(ciudad);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto));
		ciudad.setAeropuertos(aeropuertos);
		
		airportDao.saveAeropuerto(aeropuerto);
		List<Airport> aeropuertos2 = airportDao.getAllAeropuertos();
		
		Assert.assertEquals(aeropuertos2.get(0).getNombre(), "Jorge newbery");
		Assert.assertEquals(aeropuertos2.get(0).getDireccion(),"1563");
		
		airportDao.removeAeropuerto(aeropuertos2.get(0));
		cityDao.removeCiudad(ciudad);
	}
	
	/**
	 * Test actualizacion de Aeropuerto en BD exitoso
	 */
	@Test
	public void editAeropuertoSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
		cityDao.saveCiudad(ciudad);
		Airport aeropuerto = nuevoAeropuerto(ciudad);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto));
		ciudad.setAeropuertos(aeropuertos);
		
		airportDao.saveAeropuerto(aeropuerto);
		List<Airport> aeropuertos2 = airportDao.getAllAeropuertos();
		aeropuertos2.get(0).setNombre("General Mosconi");
		airportDao.updateAeropuerto(aeropuertos2.get(0));
		List<Airport> aeropuertos3 = airportDao.getAllAeropuertos();

		Assert.assertEquals(aeropuertos3.get(0).getNombre(), "General Mosconi");
		Assert.assertEquals("1563", aeropuertos3.get(0).getDireccion());
		
		airportDao.removeAeropuerto(aeropuertos3.get(0));
		cityDao.removeCiudad(ciudad);
	}
	
	/**
	 * Test borrado de Aeropuerto en BD exitoso
	 */
	@Test
	public void removeAeropuertoSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
		cityDao.saveCiudad(ciudad);
		Airport aeropuerto = nuevoAeropuerto(ciudad);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto));
		ciudad.setAeropuertos(aeropuertos);
		
		airportDao.saveAeropuerto(aeropuerto);
		List<Airport> aeropuertos2 = airportDao.getAllAeropuertos();
		airportDao.removeAeropuerto(aeropuertos2.get(0));
		cityDao.removeCiudad(ciudad);
		List<Airport> aeropuertos3 = airportDao.getAllAeropuertos();

		Assert.assertEquals(aeropuertos3.size(),0);
	}
	
	/**
	 * Crea Ciudad que contendra Aeropuerto
	 * @return Ciudad que contendra Aeropuerto
	 */
	private City nuevaCiudad(){
		City ciudad = new City();
		ciudad.setNombre("La Plata");
		ciudad.setCodPostal(1900);
		return ciudad;
	}
	
	/**
	 * Crea Aeropuerto correspondiente a la ciudad dada como parametro
	 * @param ciudad Ciudad que contendra Aeropuerto
	 * @return Aeropuerto correspondiente a la ciudad dada como parametro
	 */
	private Airport nuevoAeropuerto(City ciudad){
		Airport aeropuerto = new Airport();
		aeropuerto.setCiudad(ciudad);
		aeropuerto.setDireccion("1563");
		aeropuerto.setNombre("Jorge newbery");
		aeropuerto.setTelefono(11123123);
		return aeropuerto;
	}

}
