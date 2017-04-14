package com.agenciaDeViajesMVC.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agenciaDeViajesMVC.daos.AirlineDao;
import com.agenciaDeViajesMVC.daos.AirportDao;
import com.agenciaDeViajesMVC.daos.CityDao;
import com.agenciaDeViajesMVC.daos.FlightDao;
import com.agenciaDeViajesMVC.daos.PassengerDao;
import com.agenciaDeViajesMVC.daos.PilotDao;
import com.agenciaDeViajesMVC.daos.PlaneDao;
import com.agenciaDeViajesMVC.daos.ProviderDao;
import com.agenciaDeViajesMVC.daos.SeatDao;
import com.agenciaDeViajesMVC.daos.TicketDao;
import com.agenciaDeViajesMVC.modelos.City;

public class MainController {
	
	AirportDao airportDao;
	PlaneDao planeDao;
	CityDao cityDao;
	AirlineDao airlineDao;
	TicketDao ticketDao;
	PassengerDao passengerDao;
	PilotDao pilotDao;
	FlightDao flightDao;
	SeatDao seatDao;
	ProviderDao providerDao;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){
		
//		String message;
//		message = saveCity();
//		modifCiudad(1900);
		
//		model.addAttribute("message", "se modifico");
		return "test";
    }
	
	private String saveCity(){
		City city = new City();
		city.setPostalCode(1900);
		city.setName("La Plata");
		
		cityDao.saveCity(city);
		
		return "city was saved";
	}
	
	private void modifCiudad(Integer codPostal){
//		Ciudad ciudad = (Ciudad) ciudadDao.getCiudadByCodPostal(codPostal);
//		ciudad.setNombre("Buenos Aires");
//		ciudadDao.updateCiudad(ciudad);
	}

	public AirportDao getAirportDao() {
		return airportDao;
	}

	public void setAirportDao(AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	public PlaneDao getPlaneDao() {
		return planeDao;
	}

	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}

	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public AirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(AirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public PassengerDao getPassengerDao() {
		return passengerDao;
	}

	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}

	public PilotDao getPilotDao() {
		return pilotDao;
	}

	public void setPilotDao(PilotDao pilotDao) {
		this.pilotDao = pilotDao;
	}

	public FlightDao getFlightDao() {
		return flightDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	public SeatDao getSeatDao() {
		return seatDao;
	}

	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}

	public ProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(ProviderDao providerDao) {
		this.providerDao = providerDao;
	}
}
