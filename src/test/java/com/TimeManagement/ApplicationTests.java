package com.TimeManagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TimeManagement.repo.DoctorRepo;
import com.TimeManagement.repo.LocationRepo;
import com.TimeManagement.repo.PunchinandoutRepo;
import com.TimeManagement.repo.RoleRepo;
import com.TimeManagement.repo.SectorRepo;
import com.TimeManagement.service.DoctorService;
import com.TimeManagement.service.PunchinAndOutService;
import com.TimeManagement.models.Doctor;
import com.TimeManagement.models.Location;
import com.TimeManagement.models.Punchinandout;
import com.TimeManagement.models.Role;
import com.TimeManagement.models.Sector;
@SpringBootTest
class ApplicationTests {
	@Autowired
	DoctorRepo drepo;
	
	@Autowired
	DoctorService dserv;
	//@Autowired
//	PunchinAndOutService pserv;
	@Autowired
	PunchinandoutRepo prepo;
	@Autowired
	SectorRepo sserv;
	@Autowired
RoleRepo rserv;
	@Autowired
		LocationRepo lrepo;
	
/*	
@Test
//@Transactional
	void setschedule() {
		Punchinandout p  = new Punchinandout();
		
		p.setPunchin(LocalTime.parse("10:15"));
		p.setPunchout(LocalTime.parse("03:15"));
		p.setPunchinoutdate(LocalDate.parse("2018-12-27"));
		
		 Doctor d = dserv.getbyId(2);
		 
		 
	
		System.out.println();
		Set<Punchinandout> g=  new HashSet<>();
		g.add(p);
		
	
		
		drepo.save(d);
	
		}
	
	*/
/*	@Test
	void gedocschedule() {
		
	
	}*/
	
	
	
/*@Test
	void sector() {
		Sector s= new Sector();
		s.setId(1);
		s.setName("East");
		sserv.save(s);
		Sector s1= new Sector();
		s1.setId(2);
		s1.setName("West");
		sserv.save(s1);
}*/
	
	
/*	@Test
	void role() {
		Role r = new Role();
		rserv.save(r);
	}*/
	
	
		@Test
		void locatoion(){
			Location lo =  new Location();
			lo.setName("new yoork");
			lo.setSector(sserv.getById(1));
			lrepo.save(lo);
			
		}
	
	
	
	
	
	
	
	

	
	/*@Test
	
	void Doctor() {
		
		Doctor d= new Doctor();
		Punchinandout p  = new Punchinandout();
		
		p.setPunchin(LocalTime.parse("10:15"));
		p.setPunchout(LocalTime.parse("03:15"));
		p.setPunchinoutdate(LocalDate.parse("2018-12-27"));
		
		d.setFirstname("stco");
		d.setLastname("joseph");
		d.setPass("aab3");
		d.setFilenumber(299);
		Location lo =  lrepo.getById(1);
		d.setLocation(lo);
		d.setRole(rserv.getById(1));
		
	 
		
		dserv.addDoctor(d);
	}*/

}
