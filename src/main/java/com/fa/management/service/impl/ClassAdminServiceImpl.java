package com.fa.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.management.dao.ClassAdminDAO;
import com.fa.management.entity.Classadmin;
import com.fa.management.service.ClassAdminService;

@Service
@Transactional
public class ClassAdminServiceImpl implements ClassAdminService{
	
	@Autowired
	private ClassAdminDAO classAdminDAO;

	public List<Classadmin> getAllClassAdmin() {
		// TODO Auto-generated method stub
		return classAdminDAO.getAllClassAdmin();
	}
	
	
}
