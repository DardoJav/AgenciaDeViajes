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

import com.agenciaDeViajesMVC.daos.PlaneDao;
import com.agenciaDeViajesMVC.daos.ProviderDao;
import com.agenciaDeViajesMVC.modelos.Plane;
import com.agenciaDeViajesMVC.modelos.Provider;

/**
 * Tests de AvionDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class AvionDaoTest {
	
	@Inject
	private PlaneDao planeDao;
	
	@Inject
	private ProviderDao providerDao;

	/**
	 * Test guardado de Avion en BD exitoso
	 */
	@Test
	public void saveAvionSuccessfullTest() {
		
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);

		planeDao.saveAvion(plane);
		List<Plane> aviones2 = planeDao.getAllAviones();
		
		Assert.assertEquals(aviones2.get(0).getModelo(), "AB123");
		
		planeDao.removeAvion(aviones2.get(0));
		providerDao.removeProveedor(provider);
	}
	
	/**
	 * Test actualizacion de Avion en BD exitoso
	 */
	@Test
	public void editAvionSuccessfullTest() {
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		
		planeDao.saveAvion(plane);
		List<Plane> aviones2 = planeDao.getAllAviones();
		aviones2.get(0).setModelo("ZY654");
		planeDao.updateAvion(aviones2.get(0));
		List<Plane> aviones3 = planeDao.getAllAviones();
		
		Assert.assertEquals(aviones3.get(0).getModelo(), "ZY654");
		
		planeDao.removeAvion(aviones3.get(0));
		providerDao.removeProveedor(provider);
	}
	
	/**
	 * Test borrado de Avion en BD exitoso
	 */
	@Test
	public void removeAvionSuccessfullTest() {
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		
		planeDao.saveAvion(plane);
		List<Plane> aviones2 = planeDao.getAllAviones();
		planeDao.removeAvion(aviones2.get(0));
		List<Plane> aviones3 = planeDao.getAllAviones();

		Assert.assertEquals(aviones3.size(),0);
		
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
	 * Crea Avion
	 * @return Avion
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
	
}
