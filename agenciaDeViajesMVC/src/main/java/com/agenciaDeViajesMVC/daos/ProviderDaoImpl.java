package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.Provider;

public class ProviderDaoImpl implements ProviderDao{
	
private SessionFactory sessionFactory;
	
	@Transactional
	public void saveProvider(Provider provider){
		Session session = sessionFactory.getCurrentSession();
		session.save(provider);
	}

	@Transactional
	public void updateProvider(Provider provider) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(provider);		
	}

	@Transactional
	public void removeProvider(Provider provider) {
		Session session = this.sessionFactory.getCurrentSession();
		Provider provider2 = (Provider) session.load(Provider.class, new Integer(provider.getIdProvider()));
		if(null != provider2){
			session.delete(provider2);
		}
	}
	
	@Transactional
	public List<Provider> getAllProviders() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Provider.class);
        List<Provider> providers = criteria.list();
        return providers;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
