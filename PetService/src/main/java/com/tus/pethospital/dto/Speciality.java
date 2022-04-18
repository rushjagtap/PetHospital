package com.tus.pethospital.dto;



public class Speciality {

	public Speciality(String id, String petType) {
		this.id = id;
		this.petType = petType;
	}
	public Speciality()
	{
		
	}
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	private String petType;
	

}
