package com.fa.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.management.dao.LocationDAO;
import com.fa.management.entity.Location;
import com.fa.management.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationDAO locationDAO;
	
	public List<Location> getLocations() {
		// TODO Auto-generated method stub
		return locationDAO.getLocations();
	}

}
