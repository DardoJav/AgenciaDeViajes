package com.agenciaDeViajesMVC.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Passenger;

public class PassengerDaoImpl implements PassengerDao{

	private SessionFactory sessionFactory;
	
	@Transactional
	public void savePassenger(Passenger passenger){
		Session session = sessionFactory.getCurrentSession();
		session.save(passenger);
	}

	@Transactional
	public void updatePassenger(Passenger passenger) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(passenger);		
	}

	@Transactional
	public void removePassenger(Passenger passenger) {
		Session session = this.sessionFactory.getCurrentSession();
		Passenger passenger2 = (Passenger) session.load(Passenger.class, new Integer(passenger.getIdPassenger()));
		if(null != passenger2){
			session.delete(passenger2);
		}
	}
	
	@Transactional
	public List<Passenger> getAllPassengers() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Passenger.class);
        List<Passenger> passengers = criteria.list();
        return passengers;
	}
	
//	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public Passenger findPassengerByName(String name) {

		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers = getSessionFactory().getCurrentSession()
			.createQuery("from Pasajero where nombre=?")
			.setParameter(0, name).list();

		if (passengers.size() > 0) {
			return passengers.get(0);
		} else {
			return null;
		}

	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
