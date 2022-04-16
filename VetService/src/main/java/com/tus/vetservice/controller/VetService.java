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
	
	public Vet addVet(Vet Vet)
	{
		return VetRepository.save(Vet);
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
		
		Vet existingVet = optionalVet.get();
		existingVet.setAddress(Vet.getAddress());
		existingVet.setCity(Vet.getCity());
		existingVet.setContactNumber(Vet.getContactNumber());
		existingVet.setName(Vet.getName());
		existingVet.setSpeciality(Vet.getSpeciality());
		
		return VetRepository.save(existingVet);
	}

}
