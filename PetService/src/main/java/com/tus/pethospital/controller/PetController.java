package com.tus.pethospital.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tus.pethospital.entity.Pet;

@RestController
@RequestMapping(path = "/api/v1")
public class PetController {
	
	
	private final PetService petService;
	
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	
	
	@RequestMapping(value = "/pets" ,method = RequestMethod.GET)
	public List<Pet> getAllPet()
	{
		return petService.getAllPet();
	}
	
	@RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
	public Optional<Pet> getPet(@PathVariable int id)
	{
		return petService.getPet(id);
	}
	
	
		
	@RequestMapping(value ="/pets", method = RequestMethod.POST)
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet)
	{
		Pet savedPet = petService.addPet(pet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPet.getId()).toUri();
		new ResponseEntity<Pet>(savedPet, HttpStatus.CREATED);
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value ="/pets/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet pet)
	{
		Pet updatedPet = petService.updatePet(id, pet);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(updatedPet.getId()).toUri();
		new ResponseEntity<Pet>(updatedPet,HttpStatus.OK);
		return ResponseEntity.ok(updatedPet);
	}
	
	@RequestMapping(value ="/pets/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pet> updatePet(@PathVariable int id)
	{
		Pet deletedPet = petService.deletePet(id);
		return new ResponseEntity<Pet>(deletedPet,HttpStatus.OK);
	}

}
