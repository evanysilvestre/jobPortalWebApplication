package com.luv2code.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.repository.UsersRepository;

@Service
public class UsersService {
	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		return usersRepository.save(users);
	}
	
	public Optional<Users> getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
}
