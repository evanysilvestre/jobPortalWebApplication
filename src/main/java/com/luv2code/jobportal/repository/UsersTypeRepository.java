package com.luv2code.jobportal.repository;
/*
 Repository → Handles persistence (database access, CRUD operations).
 Repository → talks to the database (also part of the Model).
 
 This repository is the data access layer for the UsersType table. That interface is a Spring Data JPA repository and its purpose is to provide database CRUD operations for the UsersType entity automatically, so you don’t have to write them manually. You don’t need to write anything inside unless you want custom queries.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.jobportal.entity.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
	
}