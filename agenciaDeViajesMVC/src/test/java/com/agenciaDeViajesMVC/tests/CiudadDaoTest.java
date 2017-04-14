package com.agenciaDeViajesMVC.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.agenciaDeViajesMVC.daos.CityDao;
import com.agenciaDeViajesMVC.modelos.Airport;
import com.agenciaDeViajesMVC.modelos.City;


/**
 * Tests de CiudadDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class CiudadDaoTest extends DBTestCase {
	
	@Inject
	private CityDao cityDao;
	
	protected DatabaseOperation getSetUpOperation() throws Exception
    {
        return DatabaseOperation.REFRESH;
    } 
	
	protected DatabaseOperation getTearDownOperation() throws Exception
    {
        return DatabaseOperation.NONE;
    }
	
//	protected IDataSet setUpDatabase() throws DataSetException, FileNotFoundException{
//		IDataSet dataset = new FlatXmlDataSetBuilder().build(new FileInputStream("dataSetCiudad.xml"));
//		return dataset;
//	}
//	
//	@Test
//	public void testCiudad() throws DataSetException, FileNotFoundException{
//		IDataSet datasetCiudad;
//		datasetCiudad = setUpDatabase();
//	}

	/**
	 * Test guardado de Ciudad en BD exitoso
	 */
	@Test
	public void saveCiudadSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
//		Set<Aeropuerto> aeropuertos = nuevaColeccionAeropuertos(ciudad);
//		ciudad.setAeropuertos(aeropuertos);
		
		cityDao.saveCiudad(ciudad);
		List<City> ciudades = cityDao.getAllCiudades();
		
		Assert.assertEquals(ciudad.getNombre(), ciudades.get(0).getNombre());
		Assert.assertEquals(ciudad.getCodPostal(), ciudades.get(0).getCodPostal());
		
		cityDao.removeCiudad(ciudades.get(0));
	}
	
	/**
	 * Test actualizacion de Ciudad en BD exitoso
	 */
	@Test
	public void editCiudadSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
//		Set<Aeropuerto> aeropuertos = nuevaColeccionAeropuertos(ciudad);
//		ciudad.setAeropuertos(aeropuertos);

		cityDao.saveCiudad(ciudad);
		List<City> ciudades = cityDao.getAllCiudades();
		ciudades.get(0).setNombre("Buenos Aires");
		cityDao.updateCiudad(ciudades.get(0));
		List<City> ciudades2 = cityDao.getAllCiudades();

		Assert.assertNotEquals(ciudades2.get(0).getNombre(), "La Plata");
		
		cityDao.removeCiudad(ciudades2.get(0));
	}
	
	/**
	 * Test borrado de Ciudad en BD exitoso
	 */
	@Test
	public void removeCiudadSuccessfullTest() {
		
		City ciudad = nuevaCiudad();
//		Set<Aeropuerto> aeropuertos = nuevaColeccionAeropuertos(ciudad);
//		ciudad.setAeropuertos(aeropuertos);

		cityDao.saveCiudad(ciudad);
		List<City> ciudades = cityDao.getAllCiudades();
		cityDao.removeCiudad(ciudades.get(0));
		List<City> ciudades2 = cityDao.getAllCiudades();

		Assert.assertEquals(ciudades2.size(),0);
	}
	
//	@Test
//	public void removeCiudadFailTest() {
//		
//		Ciudad ciudad = new Ciudad();
//		ciudad.setCodPostal(1900);
//		ciudad.setNombre("La Plata");
//
//		ciudadDao.saveCiudad(ciudad);
//		List<Ciudad> ciudades = ciudadDao.getAllCiudades();
//		ciudadDao.removeCiudad(ciudades.get(0));
//		List<Ciudad> ciudades2 = ciudadDao.getAllCiudades();
//		ciudadDao.removeCiudad(ciudades2.get(0));
//		
//		exception.expect(InvocationTargetException.class);
//	}
	
	/**
	 * Crea Ciudad
	 * @return Ciudad
	 */
	private City nuevaCiudad(){
		City ciudad = new City();
		ciudad.setNombre("La Plata");
		ciudad.setCodPostal(1900);
		return ciudad;
	}
	
	/**
	 * Crea Aeropuertos correspondientes a Ciudad dada como parametro
	 * @param ciudad que contendra Aeropuertos
	 * @return Aeropuertos
	 */
	private Set<Airport> nuevaColeccionAeropuertos(City ciudad){
		Airport aeropuerto = new Airport();
		aeropuerto.setCiudad(ciudad);
		aeropuerto.setDireccion("1563");
		aeropuerto.setNombre("Jorge newbery");
		aeropuerto.setTelefono(011123123);
		Set<Airport> aeropuertos = new HashSet<Airport>();
		aeropuertos.add(aeropuerto);
		return aeropuertos;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dataSetCiudad.xml"));
	}
	
}
