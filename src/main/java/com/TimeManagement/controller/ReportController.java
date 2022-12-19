package com.TimeManagement.controller;



import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TimeManagement.models.Punchinandout;
import com.TimeManagement.service.DoctorService;
import com.TimeManagement.service.PunchinAndOutService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/report")
public class ReportController {

	
	@Autowired
	PunchinAndOutService pserv;
	
	
	@Autowired
	DoctorService dserv;
	
	
	
	
	@GetMapping()
    public ResponseEntity<Set<Punchinandout>> findallbydates(@RequestParam("date1") 
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date1,@RequestParam("date2") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date2) {
        // ...
	Set<Punchinandout> d =	pserv.allusersindaterange(date1,date2);
	return ResponseEntity.ok(d);
		
    }
	
	
	//   selt all custom class retrun string look at the youtube vid create query
	
	
	
	
	
	
	
	
}
