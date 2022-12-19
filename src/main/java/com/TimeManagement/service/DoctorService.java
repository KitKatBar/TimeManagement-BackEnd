package com.TimeManagement.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeManagement.models.Doctor;
import com.TimeManagement.repo.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	DoctorRepo drepo;
	
	public Doctor findbyname(String firstName) {
		
		return drepo.findByFirstName(firstName);
	}
	
	public void updateDoc(Doctor d) {
		
		if(drepo.getById(d.getId()) != null)
			drepo.save(d);
	}
	
	public Doctor getbyId(Integer id) {
		
		return drepo.findById(id).get(); // changed this from getById to findById
		
	}
	
	
	public void deleteDoctor(Doctor d) {
		
		if(drepo.getById(d.getId()) != null)
			drepo.delete(d);
	}
	
	public void deleteDoctor(Integer id) {
		drepo.deleteById(id);
	}
	
	public Integer addDoctor(Doctor doc) {
		return drepo.save(doc).getId();
	}
	
	
	
	
	
	public List<Doctor> getAllDoctor(){
		List<Doctor> doc= drepo.findAll();
		List<Doctor> dSet = new ArrayList<>();
		//Set<Doctor> dSet = new HashSet<>();
		dSet.addAll(doc);
		return dSet;
	}
	
	
	
	
	
	
}

	
	

