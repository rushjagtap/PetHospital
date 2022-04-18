package com.tus.vetservice.dto;

import java.time.LocalDate;
import java.util.Set;


public class Pet {
	private int petId;
	public Pet(int petId, String name, LocalDate birthdate, String type, Set<Visit> visits) {
		super();
		this.petId = petId;
		this.name = name;
		this.birthdate = birthdate;
		this.type = type;
		this.visits = visits;
	}
	public Pet()
	{
		
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	private String name;
	private LocalDate birthdate;
	private String type;
	private  Set<Visit> visits;
	

}
