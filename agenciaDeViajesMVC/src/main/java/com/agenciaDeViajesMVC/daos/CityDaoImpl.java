package com.agenciaDeViajesMVC.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaDeViajesMVC.modelos.City;

public class CityDaoImpl implements CityDao {

	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveCity(City city){
		Session session = sessionFactory.getCurrentSession();
		session.save(city);
	}

	@Transactional
	public void updateCity(City city) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(city);		
	}

	@Transactional
	public void removeCity(City city) {
		Session session = this.sessionFactory.getCurrentSession();
 		City city2 = (City) session.load(City.class, new Integer(city.getIdCity()));
		if(null != city2){
			session.delete(city2);
		}
	}
	
	@Transactional
	public List<City> getAllCities() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
        List<City> cities = criteria.list();
        return cities;
	}
	
	@Transactional
	public List<City> getCityByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("nombre",name));
		List<City> cities = criteria.list();
        return cities;
	}
	
//	@Transactional
//	public Ciudad getCiudadByCodPostal(Integer codPostal) {
//		Session session = this.sessionFactory.getCurrentSession();		
//		Ciudad ciudad= (Ciudad) session.load(Ciudad.class, new Integer(codPostal));
//		System.out.println("Ciudad loaded successfully");
//		return ciudad;
//	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
