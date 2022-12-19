package com.TimeManagement.models;

import java.util.Date;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="punchinandout",schema="doctor")
public class Punchinandout {



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	 
   
   private Date punchinoutdate;
   
   private Double hours;
	
	
	@OneToMany(targetEntity=Time.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "time_id", referencedColumnName="id")
	private List<Time> time;
	
	



	public List<Time> getTime() {
		return time;
	}



	public void setTime(List<Time> time) {
		this.time = time;
	}



	@ManyToOne(fetch = FetchType.LAZY, optional = false)
   // @JoinColumn(name = "doctor_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Doctor doctor;
	
	public Integer getId() {
		return id;
	}



	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Date getPunchinoutdate() {
		return punchinoutdate;
	}



	public void setPunchinoutdate(Date punchinoutdate) {
		this.punchinoutdate = punchinoutdate;
	}

	
	
}
