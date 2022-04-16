package com.tus.vetservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Speciality {
	@Id
	private String id;
	
	@Column
	private String petType;
	

}
