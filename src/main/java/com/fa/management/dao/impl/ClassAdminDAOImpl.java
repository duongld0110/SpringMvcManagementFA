package com.fa.management.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.management.dao.ClassAdminDAO;
import com.fa.management.entity.Classadmin;

@Repository
public class ClassAdminDAOImpl implements ClassAdminDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Classadmin> getAllClassAdmin() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Classadmin";
		Query query = session.createQuery(sql);
		return query.list();
	}
}
