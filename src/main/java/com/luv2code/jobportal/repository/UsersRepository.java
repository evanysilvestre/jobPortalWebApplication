package com.luv2code.jobportal.repository;
import java.util.Optional;

/*
 Repository → Handles persistence (database access, CRUD operations).
 Repository → talks to the database (also part of the Model).
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByEmail(String email);
}