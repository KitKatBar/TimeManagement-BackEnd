package com.TimeManagement.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

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

import com.TimeManagement.models.Doctor;
import com.TimeManagement.service.DoctorService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/doctor")
public class DoctorController {

	@Autowired
	DoctorService dserv;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getallDoc(){
		List<Doctor> d =  dserv.getAllDoctor();
		return ResponseEntity.ok(d);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Doctor> getDoc(@PathVariable("id") Integer id) {
		Doctor d = dserv.getbyId(id);
		return ResponseEntity.ok(d);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Void> regsiterdoc(@RequestBody Doctor d){
			dserv.addDoctor(d);
		
		return ResponseEntity.ok().build();
	}
	
	
	
	@PutMapping(path="/{id}")
	public ResponseEntity <Void> updateDoc(@PathVariable("id") Integer id, @RequestBody Doctor d){
			dserv.updateDoc(d);
	return ResponseEntity.ok().build();
	}
	
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity <Void> deletedoctor(@PathVariable("id") Integer id, @RequestBody Doctor d ) {
		if (d!= null && id.equals(d.getId())) {
			dserv.deleteDoctor(d);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	
	@PutMapping
	public ResponseEntity<Doctor> logIn(HttpSession session, @RequestBody Map<String, String> loginInfo) {
		Doctor person = dserv.findbyname(loginInfo.get("username"));
	
		if (person != null) {
			if (person.getPass().equals(loginInfo.get("password"))) {
				session.setAttribute("user", person);
				return ResponseEntity.ok(person);
			}
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
