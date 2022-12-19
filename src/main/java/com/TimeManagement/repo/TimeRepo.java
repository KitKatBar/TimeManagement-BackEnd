package com.TimeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeManagement.models.Time;

@Repository
public interface TimeRepo extends JpaRepository<Time,Integer> {

}
