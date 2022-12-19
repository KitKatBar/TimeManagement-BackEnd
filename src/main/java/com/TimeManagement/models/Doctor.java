package com.TimeManagement.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;


@Entity
@Table(name="doctor",schema="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String pass;
	private Integer fileNumber;
	
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private Role role;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public Integer getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(Integer filenumber) {
		this.fileNumber = filenumber;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
   
//@JoinColumn(name="doctor_id")
 
	
	
}

