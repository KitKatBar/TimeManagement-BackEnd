package com.TimeManagement.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TimeManagement.models.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer>  {
 public Doctor findByFirstName(String firstname);
//	@Query("select * from punchinandout were doctor_id=?1")
//	Set<Punchinandout> findByDoctorId(Integer id);
}
