package com.tus.pethospital.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_generator")
	@SequenceGenerator(name="my_generator", sequenceName="MY_SEQUENCE", allocationSize = 1)
	private int ownerId;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String contactNumber;
	
	@Column
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerId")
	private  Set<Pet> pets ;

}
