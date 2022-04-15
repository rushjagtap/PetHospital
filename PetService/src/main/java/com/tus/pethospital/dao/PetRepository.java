package com.tus.pethospital.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tus.pethospital.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
	List<Pet> findByName(String name);
	
	


}
