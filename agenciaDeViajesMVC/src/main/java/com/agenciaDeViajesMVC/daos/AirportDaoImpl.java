package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Airport;

public class AirportDaoImpl implements AirportDao{

	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveAirport(Airport airport){
		Session session = sessionFactory.getCurrentSession();
		session.save(airport);
	}

	@Transactional
	public void updateAirport(Airport airport) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(airport);		
	}

	@Transactional
	public void removeAirport(Airport airport) {
		Session session = this.sessionFactory.getCurrentSession();
		Airport airport2 = (Airport) session.load(Airport.class, new Integer(airport.getIdAirport()));
		if(null != airport2){
			session.delete(airport2);
		}
	}
	
	@Transactional
	public List<Airport> getAllAirports() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Airport.class);
        List<Airport> airports = criteria.list();
        return airports;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
