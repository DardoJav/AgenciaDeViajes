package com.agenciaDeViajesMVC.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
import com.agenciaDeViajesMVC.daos.PlaneDao;
import com.agenciaDeViajesMVC.daos.CityDao;
import com.agenciaDeViajesMVC.daos.AirlineDao;
import com.agenciaDeViajesMVC.daos.PilotDao;
import com.agenciaDeViajesMVC.daos.ProviderDao;
import com.agenciaDeViajesMVC.daos.FlightDao;
import com.agenciaDeViajesMVC.modelos.Airport;
import com.agenciaDeViajesMVC.modelos.Plane;
import com.agenciaDeViajesMVC.modelos.City;
import com.agenciaDeViajesMVC.modelos.Airline;
import com.agenciaDeViajesMVC.modelos.Pilot;
import com.agenciaDeViajesMVC.modelos.Provider;
import com.agenciaDeViajesMVC.modelos.Flight;

/**
 * Tests de VueloDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class VueloDaoTest {

	@Inject
	private AirportDao airportDao;

	@Inject
	private PilotDao pilotDao;
	
	@Inject
	private AirlineDao airlineDao;

	@Inject
	private PlaneDao planeDao;
	
	@Inject
	private CityDao cityDao;
	
	@Inject
	private FlightDao flightDao;
	
	@Inject
	private ProviderDao providerDao;
	
	/**
	 * Test guardado de Ciudad en BD exitoso
	 * @throws ParseException
	 */
	@Test
	public void saveVueloSuccessfullTest() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);

		planeDao.saveAvion(plane);
		Pilot piloto = nuevoPiloto();
		pilotDao.savePiloto(piloto);
		Airline lineaAerea = nuevaLineaAerea();
		airlineDao.saveLineaAerea(lineaAerea);
		
		City ciudad1 = nuevaCiudad1();
		cityDao.saveCiudad(ciudad1);
		Airport aeropuerto1 = nuevoAeropuerto1(ciudad1);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto1));
		ciudad1.setAeropuertos(aeropuertos);
		airportDao.saveAeropuerto(aeropuerto1);

		City ciudad2 = nuevaCiudad2();
		cityDao.saveCiudad(ciudad2);
		Airport aeropuerto2 = nuevoAeropuerto2(ciudad2);
		Set<Airport> aeropuertos2 = new HashSet<Airport>(Arrays.asList(aeropuerto2));
		ciudad2.setAeropuertos(aeropuertos2);
		airportDao.saveAeropuerto(aeropuerto2);
		
		Flight vuelo = nuevoVuelo(lineaAerea, piloto, aeropuerto1, aeropuerto2, plane);
		Set<Flight> vuelos = new HashSet<Flight>(Arrays.asList(vuelo));
		lineaAerea.setVuelos(vuelos);
		piloto.setVuelos(vuelos);
		aeropuerto1.setVuelosSalida(vuelos);
		aeropuerto2.setVuelosLlegada(vuelos);
		plane.setVuelos(vuelos);
		
		flightDao.saveVuelo(vuelo);
		List<Flight> vuelos2 = flightDao.getAllVuelos();
		
		Assert.assertEquals(sdf.format(vuelos2.get(0).getFechaPartida()),"01-04-2017");
		
		flightDao.removeVuelo(vuelos2.get(0));
		planeDao.removeAvion(plane);
		providerDao.removeProveedor(provider);
		airlineDao.removeLineaAerea(lineaAerea);
		pilotDao.removePiloto(piloto);
//		aeropuertoDao.removeAeropuerto(aeropuerto2);
		cityDao.removeCiudad(ciudad2);
//		aeropuertoDao.removeAeropuerto(aeropuerto1);
		cityDao.removeCiudad(ciudad1);
		
	}
	
	/**
	 * Test actualizacion de Vuelo en BD exitoso
	 * @throws ParseException
	 */
	@Test
	public void editVueloSuccessfullTest() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = "02-04-2017";		
		Date newDate = sdf.parse(dateInString);
		
		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		planeDao.saveAvion(plane);
		
		Pilot piloto = nuevoPiloto();
		pilotDao.savePiloto(piloto);
		Airline lineaAerea = nuevaLineaAerea();
		airlineDao.saveLineaAerea(lineaAerea);
		
		City ciudad1 = nuevaCiudad1();
		cityDao.saveCiudad(ciudad1);
		Airport aeropuerto1 = nuevoAeropuerto1(ciudad1);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto1));
		ciudad1.setAeropuertos(aeropuertos);
		airportDao.saveAeropuerto(aeropuerto1);

		City ciudad2 = nuevaCiudad2();
		cityDao.saveCiudad(ciudad2);
		Airport aeropuerto2 = nuevoAeropuerto2(ciudad2);
		Set<Airport> aeropuertos2 = new HashSet<Airport>(Arrays.asList(aeropuerto2));
		ciudad2.setAeropuertos(aeropuertos2);
		airportDao.saveAeropuerto(aeropuerto2);
		
		Flight vuelo = nuevoVuelo(lineaAerea, piloto, aeropuerto1, aeropuerto2, plane);
		Set<Flight> vuelos = new HashSet<Flight>(Arrays.asList(vuelo));
		lineaAerea.setVuelos(vuelos);
		piloto.setVuelos(vuelos);
		aeropuerto1.setVuelosSalida(vuelos);
		aeropuerto2.setVuelosLlegada(vuelos);
		plane.setVuelos(vuelos);
		
		flightDao.saveVuelo(vuelo);
		List<Flight> vuelos2 = flightDao.getAllVuelos();
		vuelos2.get(0).setFechaPartida(newDate);
		flightDao.updateVuelo(vuelos2.get(0));
		List<Flight> vuelos3 = flightDao.getAllVuelos();
		
		Assert.assertEquals(sdf.format(vuelos3.get(0).getFechaPartida()),"02-04-2017");
		
		flightDao.removeVuelo(vuelos2.get(0));
		planeDao.removeAvion(plane);
		providerDao.removeProveedor(provider);
		airlineDao.removeLineaAerea(lineaAerea);
		pilotDao.removePiloto(piloto);
		airportDao.removeAeropuerto(aeropuerto2);
		cityDao.removeCiudad(ciudad2);
		airportDao.removeAeropuerto(aeropuerto1);
		cityDao.removeCiudad(ciudad1);
		
	}
	
	/**
	 * Test borrado de Vuelo en BD exitoso
	 * @throws ParseException
	 */
	@Test
	public void removeVueloSuccessfullTest() throws ParseException {

		Provider provider = nuevoProveedor();
		providerDao.saveProveedor(provider);
		Plane plane = nuevoAvion(provider);
		Set<Plane> aviones = new HashSet<Plane>(Arrays.asList(plane));
		provider.setAviones(aviones);
		planeDao.saveAvion(plane);
		
		Pilot piloto = nuevoPiloto();
		pilotDao.savePiloto(piloto);
		Airline lineaAerea = nuevaLineaAerea();
		airlineDao.saveLineaAerea(lineaAerea);
		
		City ciudad1 = nuevaCiudad1();
		cityDao.saveCiudad(ciudad1);
		Airport aeropuerto1 = nuevoAeropuerto1(ciudad1);
		Set<Airport> aeropuertos = new HashSet<Airport>(Arrays.asList(aeropuerto1));
		ciudad1.setAeropuertos(aeropuertos);
		airportDao.saveAeropuerto(aeropuerto1);

		City ciudad2 = nuevaCiudad2();
		cityDao.saveCiudad(ciudad2);
		Airport aeropuerto2 = nuevoAeropuerto2(ciudad2);
		Set<Airport> aeropuertos2 = new HashSet<Airport>(Arrays.asList(aeropuerto2));
		ciudad2.setAeropuertos(aeropuertos2);
		airportDao.saveAeropuerto(aeropuerto2);
		
		Flight vuelo = nuevoVuelo(lineaAerea, piloto, aeropuerto1, aeropuerto2, plane);
		Set<Flight> vuelos = new HashSet<Flight>(Arrays.asList(vuelo));
		lineaAerea.setVuelos(vuelos);
		piloto.setVuelos(vuelos);
		aeropuerto1.setVuelosSalida(vuelos);
		aeropuerto2.setVuelosLlegada(vuelos);
		plane.setVuelos(vuelos);
		
		flightDao.saveVuelo(vuelo);
		List<Flight> vuelos2 = flightDao.getAllVuelos();
		
		flightDao.removeVuelo(vuelos2.get(0));
		planeDao.removeAvion(plane);
		providerDao.removeProveedor(provider);
		airlineDao.removeLineaAerea(lineaAerea);
		pilotDao.removePiloto(piloto);
		airportDao.removeAeropuerto(aeropuerto2);
		cityDao.removeCiudad(ciudad2);
		airportDao.removeAeropuerto(aeropuerto1);
		cityDao.removeCiudad(ciudad1);
		
		List<Flight> vuelos3 = flightDao.getAllVuelos();

		Assert.assertEquals(vuelos3.size(),0);
	}
	
	/**
	 * Crea LineaAerea que contendra Vuelo
	 * @return LineaAerea que contendra Vuelo
	 */
	private Airline nuevaLineaAerea(){
		Airline lineaAerea = new Airline();
		lineaAerea.setNombre("LAN");
		return lineaAerea;
	}
	
	/**
	 * Crea Piloto que contendra Vuelo
	 * @return Piloto que contendra Vuelo
	 */
	private Pilot nuevoPiloto(){
		Pilot piloto = new Pilot();
		piloto.setNombre("Lucas");
		piloto.setApellido("Gauna");
		piloto.setDni(20123123);
		piloto.setNroMatricula(111222333);
		return piloto;
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
	 * Crea Avion que contendra Vuelo
	 * @return Avion que contendra Vuelo
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
	 * Crea AeropuertoOrigen (Aeropuerto1 correspondiente a Ciudad1) que contendra Vuelo
	 * @return AeropuertoOrigen que contendra Vuelo
	 */
	private Airport nuevoAeropuerto1(City ciudad){
		Airport aeropuerto = new Airport();
		aeropuerto.setCiudad(ciudad);
		aeropuerto.setDireccion("1563");
		aeropuerto.setNombre("Jorge newbery");
		aeropuerto.setTelefono(11123123);
		return aeropuerto;
	}
	
	/**
	 * Crea AeropuertoDestino (Aeropuerto2 correspondiente a Ciudad2) que contendra Vuelo
	 * @return AeropuertoDestino que contendra Vuelo
	 */
	private Airport nuevoAeropuerto2(City ciudad){
		Airport aeropuerto = new Airport();
		aeropuerto.setCiudad(ciudad);
		aeropuerto.setDireccion("54332");
		aeropuerto.setNombre("General Mosconi");
		aeropuerto.setTelefono(221789789);
		return aeropuerto;
	}
	
	/**
	 * Crea Ciudad1 que contendra AeropuertoOrigen
	 * @return Ciudad1
	 */
	private City nuevaCiudad1(){
		City ciudad = new City();
		ciudad.setNombre("La Plata");
		ciudad.setCodPostal(1900);
		return ciudad;
	}
	
	/**
	 * Crea Ciudad2 que contendra AeropuertoDestino
	 * @return Ciudad2
	 */
	private City nuevaCiudad2(){
		City ciudad = new City();
		ciudad.setNombre("Buenos Aires");
		ciudad.setCodPostal(1000);
		return ciudad;
	}
	
	/**
	 * Crea Vuelo con sus respectivas correspondencias a LineaAerea, Piloto, AeropuertoOrigen, AeropuertoDestino y Avion
	 * @param lineaAerea que contendra Vuelo
	 * @param piloto que contendra Vuelo
	 * @param aeropuertoOrigen que contendra Vuelo
	 * @param aeropuertoDestino que contendra Vuelo
	 * @param plane que contendra Vuelo
	 * @return Vuelo
	 * @throws ParseException
	 */
	private Flight nuevoVuelo(Airline lineaAerea,Pilot piloto, Airport aeropuertoOrigen, Airport aeropuertoDestino, Plane plane) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString1 = "03-04-2017";
		String dateInString2 = "01-04-2017";		
		Date dateLlegada = sdf.parse(dateInString1);
		Date datePartida = sdf.parse(dateInString2);
		Flight vuelo = new Flight();
		vuelo.setFechaLlegada(dateLlegada);
		vuelo.setFechaPartida(datePartida);
		vuelo.setNroVuelo(1234);
		vuelo.setLineaAerea(lineaAerea);
		vuelo.setPiloto(piloto);
		vuelo.setAeropuertoOrigen(aeropuertoOrigen);
		vuelo.setAeropuertoDestino(aeropuertoDestino);
		vuelo.setAvion(plane);
		
		return vuelo;
	}
	
}
