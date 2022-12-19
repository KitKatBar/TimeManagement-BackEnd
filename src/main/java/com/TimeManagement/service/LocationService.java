package com.TimeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeManagement.models.Location;
import com.TimeManagement.repo.LocationRepo;
@Service
public class LocationService {

	@Autowired
	LocationRepo lserv;
	
	public List<Location> listoflocation(){
		
		List<Location> llist= lserv.findAll();
		return llist;
		
	}
	
	
	
	
}
