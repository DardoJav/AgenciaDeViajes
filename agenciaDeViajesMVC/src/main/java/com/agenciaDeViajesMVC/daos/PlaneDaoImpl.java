package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Plane;

public class PlaneDaoImpl implements PlaneDao {

	private SessionFactory sessionFactory;
	
	@Transactional
	public void savePlane(Plane plane){
		Session session = sessionFactory.getCurrentSession();
		session.save(plane);
	}

	@Transactional
	public void updatePlane(Plane plane) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(plane);		
	}

	@Transactional
	public void removePlane(Plane plane) {
		Session session = this.sessionFactory.getCurrentSession();
		Plane plane2 = (Plane) session.load(Plane.class, new Integer(plane.getIdPlane()));
		if(null != plane2){
			session.delete(plane2);
		}
	}
	
	@Transactional
	public List<Plane> getAllPlanes() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Plane.class);
        List<Plane> planes = criteria.list();
        return planes;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
