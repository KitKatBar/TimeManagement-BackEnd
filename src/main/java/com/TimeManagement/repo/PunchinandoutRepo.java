package com.TimeManagement.repo;


import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TimeManagement.models.Punchinandout;
@Repository
public interface PunchinandoutRepo extends JpaRepository<Punchinandout,Integer>{
	Set<Punchinandout> findByDoctorId(Integer id);
	Set<Punchinandout>  findAllBypunchinoutdateBetween(
		      Date punchinoutdateStart,
		      Date punchinoutdateEnd);

	
	
	
/*	@Query("SELECT p FROM punchinandout p INNER JOIN doctor ON doctor.id = p.doctor_id")
	public String findBydoctorfirst();*/
}
