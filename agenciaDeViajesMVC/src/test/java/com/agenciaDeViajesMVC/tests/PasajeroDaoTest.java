package com.agenciaDeViajesMVC.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agenciaDeViajesMVC.daos.PasajeroDao;
import com.agenciaDeViajesMVC.modelos.Ticket;
import com.agenciaDeViajesMVC.modelos.Passenger;

/**
 * Tests de PasajeroDao
 * @author dardo.luna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
// @Transactional
public class PasajeroDaoTest {

	@Inject
	private PasajeroDao pasajeroDao;

	/**
	 * Test guardado de Pasajero en BD exitoso
	 */
	@Test
	public void savePasajeroSuccessfullTest() {

		Passenger passenger = nuevoPasajero();

		pasajeroDao.savePasajero(passenger);
		List<Passenger> passengers = pasajeroDao.getAllPasajeros();

		Assert.assertEquals(passengers.get(0).getNombre(), "Jorge");
		Assert.assertEquals(passengers.get(0).getApellido(), "Rodriguez");

		pasajeroDao.removePasajero(passengers.get(0));
	}

	/**
	 * Test actualizacion de Pasajero en BD exitoso
	 */
	@Test
	public void editPasajeroSuccessfullTest() {

		Passenger passenger = nuevoPasajero();

		pasajeroDao.savePasajero(passenger);
		List<Passenger> passengers = pasajeroDao.getAllPasajeros();
		passengers.get(0).setNombre("Pedro");
		pasajeroDao.updatePasajero(passengers.get(0));
		List<Passenger> pasajeros2 = pasajeroDao.getAllPasajeros();

		Assert.assertEquals(pasajeros2.get(0).getNombre(), "Pedro");

		pasajeroDao.removePasajero(pasajeros2.get(0));
	}

	/**
	 * Test borrado de Pasajero en BD exitoso
	 */
	@Test
	public void removePasajeroSuccessfullTest() {

		Passenger passenger = nuevoPasajero();

		pasajeroDao.savePasajero(passenger);
		List<Passenger> passengers = pasajeroDao.getAllPasajeros();
		pasajeroDao.removePasajero(passengers.get(0));
		List<Passenger> pasajeros2 = pasajeroDao.getAllPasajeros();

		Assert.assertEquals(pasajeros2.size(), 0);
	}

	/**
	 * Crea Pasajero
	 * @return Pasajero
	 */
	private Passenger nuevoPasajero() {
		Passenger passenger = new Passenger();
		passenger.setNombre("Jorge");
		passenger.setApellido("Rodriguez");
		passenger.setDni(30234234);
		return passenger;
	}

	/**
	 * Crea Pasajes correspondientes a Pasajero dado como parametro
	 * @param passenger que contendra Pasajes
	 * @return Pasajes
	 */
	private Set<Ticket> nuevaColeccionPasajes(Passenger passenger) {
		Ticket ticket = new Ticket();
		ticket.setPasajero(passenger);
		Set<Ticket> tickets = new HashSet<Ticket>();
		tickets.add(ticket);
		return tickets;
	}

}
