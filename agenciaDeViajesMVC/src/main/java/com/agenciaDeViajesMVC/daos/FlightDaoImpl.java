package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Flight;

public class FlightDaoImpl implements FlightDao{
	
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveFlight(Flight flight){
		Session session = sessionFactory.getCurrentSession();
		session.save(flight);
	}

	@Transactional
	public void updateFlight(Flight flight) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(flight);		
	}

	@Transactional
	public void removeFlight(Flight flight) {
		Session session = this.sessionFactory.getCurrentSession();
		Flight flight2 = (Flight) session.load(Flight.class, new Integer(flight.getIdFlight()));
		if(null != flight2){
			session.delete(flight2);
		}
	}
	
	@Transactional
	public List<Flight> getAllFlights() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Flight.class);
        List<Flight> flights = criteria.list();
        return flights;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
