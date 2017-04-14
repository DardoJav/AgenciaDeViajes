package com.agenciaDeViajesMVC.tests;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agenciaDeViajesMVC.daos.PilotDao;
import com.agenciaDeViajesMVC.modelos.Pilot;

/**
 * Tests de PilotoDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class PilotoDaoTest {
	
	@Inject
	private PilotDao pilotDao;
	
	/**
	 * Test guardado de Piloto en BD exitoso
	 */
	@Test
	public void savePilotoSuccessfullTest() {
		
		Pilot piloto = nuevoPiloto();
		
		pilotDao.savePiloto(piloto);
		List<Pilot> pilotos = pilotDao.getAllPilotos();
		
		Assert.assertEquals(pilotos.get(0).getNombre(), "Lucas");
		
		pilotDao.removePiloto(pilotos.get(0));
	}
	
	/**
	 * Test actualizacion de Piloto en BD exitoso
	 */
	@Test
	public void editPilotoSuccessfullTest() {
		
		Pilot piloto = nuevoPiloto();
		
		pilotDao.savePiloto(piloto);
		List<Pilot> pilotos = pilotDao.getAllPilotos();
		pilotos.get(0).setNombre("Martin");
		pilotDao.updatePiloto(pilotos.get(0));
		List<Pilot> pilotos2 = pilotDao.getAllPilotos();
		
		Assert.assertEquals(pilotos2.get(0).getNombre(), "Martin");
		
		pilotDao.removePiloto(pilotos2.get(0));
	}
	
	/**
	 * Test borrado de Piloto en BD exitoso
	 */
	@Test
	public void removePilotoSuccessfullTest() {
		
		Pilot piloto = nuevoPiloto();
		
		pilotDao.savePiloto(piloto);
		List<Pilot> pilotos = pilotDao.getAllPilotos();
		pilotDao.removePiloto(pilotos.get(0));
		List<Pilot> pilotos2 = pilotDao.getAllPilotos();

		Assert.assertEquals(pilotos2.size(),0);
		
	}
	
	/**
	 * Crea Piloto
	 * @return Piloto
	 */
	private Pilot nuevoPiloto(){
		Pilot piloto = new Pilot();
		piloto.setNombre("Lucas");
		piloto.setDni(20123123);
		piloto.setNroMatricula(111222333);
		return piloto;
	}

}
