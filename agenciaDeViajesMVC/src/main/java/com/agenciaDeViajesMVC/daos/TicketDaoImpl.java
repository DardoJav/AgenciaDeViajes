package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Ticket;

public class TicketDaoImpl implements TicketDao{

	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveTicket(Ticket ticket){
		Session session = sessionFactory.getCurrentSession();
		session.save(ticket);
	}

	@Transactional
	public void updateTicket(Ticket ticket) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ticket);		
	}

	@Transactional
	public void removeTicket(Ticket ticket) {
		Session session = this.sessionFactory.getCurrentSession();
		Ticket ticket2 = (Ticket) session.load(Ticket.class, new Integer(ticket.getIdTicket()));
		if(null != ticket2){
			session.delete(ticket2);
		}
	}
	
	@Transactional
	public List<Ticket> getAllTickets() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Ticket.class);
        List<Ticket> tickets = criteria.list();
        return tickets;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
