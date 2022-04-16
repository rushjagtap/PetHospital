package com.tus.vetservice.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Vet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_generator")
	@SequenceGenerator(name="my_generator", sequenceName="MY_SEQUENCE", allocationSize = 1)
	private int vetId;
	
	@Column(nullable = false)
	private String name;
	
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

	@Column
	private String address;
	
	@Column
	private String contactNumber;
	
	@Column
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "vetId")
	private  Set<Speciality> speciality;

}
