package com.TimeManagement.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TimeManagement.models.Punchinandout;
import com.TimeManagement.repo.PunchinandoutRepo;

@Service
public class PunchinAndOutService {

	
	@Autowired
	PunchinandoutRepo psserv;

	public Set<Punchinandout> findByDoctorId(Integer id) {
		// TODO Auto-generated method stub
		return psserv.findByDoctorId(id) ;
	}
	
public 	Punchinandout findbyId(Integer id)
{
	return psserv.getById(id);
	}
	/*public String findallreport() {
		// TODO Auto-generated method stub
		return psserv.findBydoctorfirst();
	}*/
	

public void updateP(Punchinandout p ) {
	   if(findbyId(p.getId())!=null)
	   {   psserv.save(p);}  
}
	
	public Punchinandout  savePunchinandout( Punchinandout p) {
		return psserv.save(p);
	}
/*	public Set<Punchinandout> docschedule
 * (Integer id)
	{
		return psserv.findByDoctorId(id);
	}*/
	
	
	
	public List< Punchinandout>displayall (){
		
		return psserv.findAll();
	}
	
	
	public Set<Punchinandout> allusersindaterange(Date date1, Date date2){
		return psserv.findAllBypunchinoutdateBetween(date1, date2) ;
		
	}

	public void deleteTimeCard(Punchinandout d ) {
		// TODO Auto-generated method stub
		
		if(psserv.getById(d.getId()) != null)
			psserv.delete(d);	
		
		
		
	}
	
	
	
	
}
