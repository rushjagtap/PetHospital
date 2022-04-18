package com.tus.vetservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tus.vetservice.entity.Vet;


@Repository
public interface VetRepository extends JpaRepository<Vet, Integer>{
	List<Vet> findByName(String name);
	List<Vet> findBySpeciality_PetType(String speciality);
	

}
