package com.TimeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeManagement.models.Location;


@Repository
public interface LocationRepo extends JpaRepository<Location,Integer>{

}
