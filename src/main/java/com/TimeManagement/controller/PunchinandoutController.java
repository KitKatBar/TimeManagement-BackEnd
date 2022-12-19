package com.TimeManagement.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.TimeManagement.models.Doctor;
import com.TimeManagement.models.Punchinandout;

import com.TimeManagement.service.DoctorService;
import com.TimeManagement.service.PunchinAndOutService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/timeManagment")
public class PunchinandoutController {
	@Autowired
	DoctorService dserv;
	
	@Autowired
	PunchinAndOutService pserv;
	@PostMapping
	public ResponseEntity<Punchinandout> create(@RequestBody Punchinandout pando){
		Doctor d=  dserv.getbyId(pando.getDoctor().getId());
	
		
		
pando.setHours((double) (pando.getTime().get(1).getHour() - pando.getTime().get(2).getHour()));   
			
		
		
		pando.setDoctor(d);
		
		 Punchinandout o = pserv.savePunchinandout(pando);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	            .buildAndExpand(o.getId()).toUri();

	        return ResponseEntity.created(location).body(o);
		}
	
	/*@PostMapping()
	public String postDateTimeMode(@RequestBody Punchinandout pando) {
		Doctor d=  dserv.getbyId(pando.getDoctor().getId());
		pando.setDoctor(d);
		pserv.savePunchinandout(pando);
		return "Done!";
	}*/
	

	
	@GetMapping("/doctor/{Id}")
    public ResponseEntity<Set<Punchinandout>> viewtimecard(@PathVariable("id")  Integer Id) {
		
		
        return ResponseEntity.ok(pserv.findByDoctorId(Id));
    }
	
	
	@GetMapping
    public ResponseEntity<List<Punchinandout>> displayall() {
		
		
        return ResponseEntity.ok(pserv.displayall());
    }
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity <Void> deleteCard(@PathVariable("id") Integer id, @RequestBody Punchinandout d ) {
		if (d!= null && id.equals(d.getId())) {
			pserv.deleteTimeCard(d);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	
	
	
	
	@PutMapping(path="/{id}")
    public ResponseEntity<Void> updateTimesheet(@PathVariable("id") Integer id,@RequestBody Punchinandout pando) {
		if (pando != null && id.equals(pando.getId())) {
			pserv.updateP(pando);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
		
	
        
    }
	
	
	
	
}
