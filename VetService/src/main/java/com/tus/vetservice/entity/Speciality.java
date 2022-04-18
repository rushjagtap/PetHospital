package com.tus.vetservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_generator_speciality")
	@SequenceGenerator(name="my_generator_speciality", sequenceName="MY_SEQUENCE_SPECIALITY", allocationSize = 1)
	private int id;
	
	@Column
	private String petType;

	public Speciality(String petType) {
		this.petType = petType;
	}
	public Speciality()
	{
		
	}

	@Override
	public String toString() {
		return "Speciality [id=" + id + ", petType=" + petType + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
	

}
