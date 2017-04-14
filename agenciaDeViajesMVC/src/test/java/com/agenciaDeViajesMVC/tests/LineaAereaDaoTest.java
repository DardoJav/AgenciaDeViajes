package com.agenciaDeViajesMVC.tests;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agenciaDeViajesMVC.daos.AirlineDao;
import com.agenciaDeViajesMVC.modelos.Airline;

/**
 * Tests de LineaAereaDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class LineaAereaDaoTest {
	
	@Inject
	private AirlineDao airlineDao;

	/**
	 * Test guardado de LineaAerea en BD exitoso
	 */
	@Test
	public void saveLineaAereaSuccessfullTest() {
		
		Airline lineaAerea = nuevaLineaAerea();
		
		airlineDao.saveLineaAerea(lineaAerea);
		List<Airline> lineasAereas = airlineDao.getAllLineasAereas();
		
		Assert.assertEquals(lineasAereas.get(0).getNombre(), "LAN");
		
		airlineDao.removeLineaAerea(lineasAereas.get(0));
	}
	
	/**
	 * Test actualizacion de LineaAerea en BD exitoso
	 */
	@Test
	public void editLineaAereaSuccessfullTest() {
		
		Airline lineaAerea = nuevaLineaAerea();
		
		airlineDao.saveLineaAerea(lineaAerea);
		List<Airline> lineasAereas = airlineDao.getAllLineasAereas();
		lineasAereas.get(0).setNombre("Aerolineas Argentinas");
		airlineDao.updateLineaAerea(lineasAereas.get(0));
		List<Airline> lineasAereas2 = airlineDao.getAllLineasAereas();
		
		Assert.assertEquals(lineasAereas2.get(0).getNombre(), "Aerolineas Argentinas");
		
		airlineDao.removeLineaAerea(lineasAereas2.get(0));
	}
	
	/**
	 * Test borrado de Aeropuerto en BD exitoso
	 */
	@Test
	public void removeLineaAereaSuccessfullTest() {
		
		Airline lineaAerea = nuevaLineaAerea();
		
		airlineDao.saveLineaAerea(lineaAerea);
		List<Airline> lineasAereas = airlineDao.getAllLineasAereas();
		airlineDao.removeLineaAerea(lineasAereas.get(0));
		List<Airline> lineasAereas2 = airlineDao.getAllLineasAereas();

		Assert.assertEquals(lineasAereas2.size(),0);
	}
	
	/**
	 * Crea LineaAerea
	 * @return LineaAerea
	 */
	private Airline nuevaLineaAerea(){
		Airline lineaAerea = new Airline();
		lineaAerea.setNombre("LAN");
		return lineaAerea;
	}
}
