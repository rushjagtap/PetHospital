package com.tus.vetservice.controller;

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

import com.tus.vetservice.entity.Vet;



@RestController
@RequestMapping(path = "/api/v1")
public class VetController {
private final VetService vetService;
	
@Autowired
public VetController(VetService vetService) {
	this.vetService = vetService;
}



@RequestMapping(value = "/vets" ,method = RequestMethod.GET)
public List<Vet> getAllVet()
{
	return vetService.getAllVet();
}

@RequestMapping(value = "/vets/{id}", method = RequestMethod.GET)
public Optional<Vet> getVet(@PathVariable int id)
{
	return vetService.getVet(id);
}


	
@RequestMapping(value ="/vets", method = RequestMethod.POST)
public ResponseEntity<Vet> createVet(@RequestBody Vet Vet)
{
	Vet savedVet = vetService.addVet(Vet);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedVet.getVetId()).toUri();
	new ResponseEntity<Vet>(savedVet, HttpStatus.CREATED);
	return ResponseEntity.created(location).build();
}

@RequestMapping(value ="/vets/{id}", method = RequestMethod.PUT)
public ResponseEntity<Vet> updateVet(@PathVariable int id, @RequestBody Vet Vet)
{
	Vet updatedVet = vetService.updateVet(id, Vet);
	//URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(updatedVet.getId()).toUri();
	new ResponseEntity<Vet>(updatedVet,HttpStatus.OK);
	return ResponseEntity.ok(updatedVet);
}

@RequestMapping(value ="/vets/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Vet> updateVet(@PathVariable int id)
{
	Vet deletedVet = vetService.deleteVet(id);
	return new ResponseEntity<Vet>(deletedVet,HttpStatus.OK);
}

}
