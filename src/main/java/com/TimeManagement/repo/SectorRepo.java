package com.TimeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TimeManagement.models.Sector;
@Repository
public interface SectorRepo extends JpaRepository<Sector,Integer> {

}
