package com.tus.pethospital.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.tus.pethospital.entity.Owner;
import com.tus.pethospital.entity.Pet;



@RestController
@RequestMapping(path = "/api/v1")
public class PetController {
	
	
	private final PetService petService;
	//private final OwnerService ownerService;
	
	
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
	public ResponseEntity<Pet> getPet(@PathVariable int id)
	{
		System.out.println("&/n &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7\n\n/n/n/n\n\n");
		Pet pet = petService.getPet(id).get();

		return new ResponseEntity<Pet>(pet,HttpStatus.OK);
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
	
	
	@RequestMapping(value = "/owners" ,method = RequestMethod.GET)
	public List<Owner> getAllOwner()
	{
		return petService.getAllOwners();
	}
	
	@RequestMapping(value = "/owners/{id}", method = RequestMethod.GET)
	public Optional<Owner> getowner(@PathVariable int id)
	{
		return petService.getOwner(id);
	}
	
	
		
	@RequestMapping(value ="/owners", method = RequestMethod.POST)
	public ResponseEntity<Owner> createOwner(@RequestBody Owner owner)
	{
		Owner savedOwner = petService.addOwner(owner);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOwner.getOwnerId()).toUri();
		new ResponseEntity<Owner>(savedOwner, HttpStatus.CREATED);
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value ="/owners/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Owner> updateOwner(@PathVariable int id, @RequestBody Owner owner)
	{
		Owner updatedOwner = petService.updateOwner(id, owner);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(updatedOwner.getId()).toUri();
		new ResponseEntity<Owner>(updatedOwner,HttpStatus.OK);
		return ResponseEntity.ok(updatedOwner);
	}
	
	@RequestMapping(value ="/owners/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Owner> updateOwner(@PathVariable int id)
	{
		Owner deletedOwner = petService.deleteOwner(id);
		return new ResponseEntity<Owner>(deletedOwner,HttpStatus.OK);
	}
	
	

}
