package com.tus.pethospital.dto;


import java.util.Set;





public class Vet {
	private int vetId;
	private String name;
	private String address;
	private String contactNumber;
	private String city;
	private  Set<Speciality> speciality;
	
	public Vet(String name, String address, String contactNumber, String city, Set<Speciality> speciality) {
		
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.city = city;
		this.speciality = speciality;
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Set<Speciality> speciality) {
		this.speciality = speciality;
	}


}

