package com.fa.management.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.management.dao.LocationDAO;
import com.fa.management.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Location> getLocations() {
		String sql = "from Location";
		Session session = sessionFactory.getCurrentSession();
		Query query =  session.createQuery(sql);
		
		return query.list();
	}

	
}
