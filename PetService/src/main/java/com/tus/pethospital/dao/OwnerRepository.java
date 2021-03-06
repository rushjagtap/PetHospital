package com.tus.pethospital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tus.pethospital.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	List<Owner> findByName(String name);
}
