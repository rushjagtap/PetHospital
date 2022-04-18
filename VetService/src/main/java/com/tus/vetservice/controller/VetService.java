package com.tus.vetservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.tus.vetservice.dao.VetRepository;
import com.tus.vetservice.entity.Vet;

@Service
public class VetService {
private final VetRepository VetRepository;
	
	@Autowired
	public VetService(VetRepository VetRepo)
	{
		this.VetRepository = VetRepo;
		
	}
	
	public List<Vet> getAllVet()
	{
		return VetRepository.findAll();
	}
	
	public Optional<Vet> getVet(int id)
	{
		return VetRepository.findById(id);
	}
	
	public List<Vet> getVet(String name)
	{
		return VetRepository.findByName(name);
	}
	
	public List<Vet> getVetbySpeciality(String speciality)
	{
		return VetRepository.findBySpeciality_PetType(speciality);
	}
	
	public Vet addVet(Vet vet)
	{
		System.out.println(vet);
		System.out.println(vet.getSpeciality());
		System.out.println(vet.getSpeciality());
		return VetRepository.save(vet);
	}
	
	public Vet deleteVet(int id)
	{
		System.out.println("test");
		Optional<Vet> optionalVet = VetRepository.findById(id);
		System.out.println(optionalVet);
		Vet existingVet = optionalVet.get();
		VetRepository.deleteById(id);
		return existingVet;
	}
	
	public Vet updateVet(int id, Vet Vet)
	{
		
		Optional<Vet> optionalVet = VetRepository.findById(id);
		System.out.println(optionalVet);
		System.out.println(id);
		Vet existingVet = optionalVet.get();
		existingVet.setAddress(Vet.getAddress());
		existingVet.setCity(Vet.getCity());
		existingVet.setContactNumber(Vet.getContactNumber());
		existingVet.setName(Vet.getName());
		existingVet.setSpeciality(Vet.getSpeciality());
		
		return VetRepository.save(existingVet);
	}

}
