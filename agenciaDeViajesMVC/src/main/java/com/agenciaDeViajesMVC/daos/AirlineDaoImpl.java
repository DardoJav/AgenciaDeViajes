package com.agenciaDeViajesMVC.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Airline;

public class AirlineDaoImpl implements AirlineDao{

	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveAirline(Airline airline){
		Session session = sessionFactory.getCurrentSession();
		session.save(airline);
	}

	@Transactional
	public void updateAirline(Airline airline) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(airline);		
	}

	@Transactional
	public void removeAirline(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Airline airline2 = (Airline) session.load(Airline.class, new Integer(id));
		if(null != airline2){
			session.delete(airline2);
		}
	}
	
	@Transactional
	public List<Airline> getAllAirlines() {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Airline> criteria = criteriaBuilder.createQuery(Airline.class);
        Root<Airline> root = criteria.from(Airline.class );
        criteria.select( root );
        List<Airline> airlines = session.createQuery( criteria ).getResultList();
        return airlines;
	}
	
	@Transactional
	public Airline getAirlineById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Airline airline = (Airline) session.load(Airline.class, new Integer(id));
		System.out.println("Airline loaded successfully");
		return airline;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
