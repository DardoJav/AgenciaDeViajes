package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Pilot;

public class PilotDaoImpl implements PilotDao{

	private SessionFactory sessionFactory;
	
	@Transactional
	public void savePilot(Pilot pilot){
		Session session = sessionFactory.getCurrentSession();
		session.save(pilot);
	}

	@Transactional
	public void updatePilot(Pilot pilot) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pilot);		
	}

	@Transactional
	public void removePilot(Pilot pilot) {
		Session session = this.sessionFactory.getCurrentSession();
		Pilot pilot2 = (Pilot) session.load(Pilot.class, new Integer(pilot.getIdPilot()));
		if(null != pilot2){
			session.delete(pilot2);
		}
	}
	
	@Transactional
	public List<Pilot> getAllPilots() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Pilot.class);
        List<Pilot> pilots = criteria.list();
        return pilots;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
