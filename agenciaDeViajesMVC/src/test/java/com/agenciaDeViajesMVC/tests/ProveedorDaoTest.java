package com.agenciaDeViajesMVC.tests;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agenciaDeViajesMVC.daos.ProviderDao;
import com.agenciaDeViajesMVC.modelos.Provider;

/**
 * Tests of ProveedorDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class ProveedorDaoTest {

	@Inject
	private ProviderDao providerDao;
	/**
	 * Test guardado de Ciudad en BD exitoso
	 */
	@Test
	public void saveProveedorSuccessfullTest() {
		
		Provider provider = nuevoProveedor();		
		providerDao.saveProveedor(provider);
		List<Provider> proveedores = providerDao.getAllProveedores();
		
		Assert.assertEquals(provider.getNombre(), proveedores.get(0).getNombre());
		
		providerDao.removeProveedor(proveedores.get(0));
	}
	
	/**
	 * Test actualizacion de Ciudad en BD exitoso
	 */
	@Test
	public void editProveedorSuccessfullTest() {
		
		Provider provider = nuevoProveedor();

		providerDao.saveProveedor(provider);
		List<Provider> proveedores = providerDao.getAllProveedores();
		proveedores.get(0).setNombre("JJRS");
		providerDao.updateProveedor(proveedores.get(0));
		List<Provider> proveedores2 = providerDao.getAllProveedores();

		Assert.assertNotEquals(proveedores2.get(0).getNombre(), "SRS");
		
		providerDao.removeProveedor(proveedores2.get(0));
	}
	
	/**
	 * Test borrado de Ciudad en BD exitoso
	 */
	@Test
	public void removeProveedorSuccessfullTest() {
		
		Provider provider = nuevoProveedor();

		providerDao.saveProveedor(provider);
		List<Provider> proveedores = providerDao.getAllProveedores();
		providerDao.removeProveedor(proveedores.get(0));
		List<Provider> proveedores2 = providerDao.getAllProveedores();

		Assert.assertEquals(proveedores2.size(),0);
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
}
