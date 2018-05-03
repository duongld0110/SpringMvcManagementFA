package com.fa.management.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.management.dao.TrainerDAO;
import com.fa.management.entity.Trainer;

@Repository
public class TrainerDAOImpl implements TrainerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Trainer> getTrainers() {
		String sql = "from Trainer";
		Session session = sessionFactory.getCurrentSession();
		Query query =  session.createQuery(sql);
		
		return query.list();
	}



	
}
