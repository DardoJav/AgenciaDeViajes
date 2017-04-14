package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Seat;

public class SeatDaoImpl implements SeatDao{

private SessionFactory sessionFactory;
	
	@Transactional
	public void saveSeat(Seat seat){
		Session session = sessionFactory.getCurrentSession();
		session.save(seat);
	}

	@Transactional
	public void updateSeat(Seat seat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(seat);		
	}

	@Transactional
	public void removeSeat(Seat seat) {
		Session session = this.sessionFactory.getCurrentSession();
		Seat seat2 = (Seat) session.load(Seat.class, new Integer(seat.getIdSeat()));
		if(null != seat2){
			session.delete(seat2);
		}
	}
	
	@Transactional
	public List<Seat> getAllSeats() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Seat.class);
        List<Seat> seats = criteria.list();
        return seats;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
