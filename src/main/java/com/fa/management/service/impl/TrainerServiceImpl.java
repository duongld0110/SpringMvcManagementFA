package com.fa.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.management.dao.TrainerDAO;
import com.fa.management.entity.Trainer;
import com.fa.management.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired 
	private TrainerDAO trainerDAO;
	
	public List<Trainer> getTrainers() {
		// TODO Auto-generated method stub
		return trainerDAO.getTrainers();
	}

	
}
