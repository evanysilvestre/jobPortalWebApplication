package com.luv2code.jobportal.services;
/*
 Service → Contains business logic (rules, calculations, validations, workflows).
 Service → business logic (still considered part of the Model in MVC).
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {
	
	private final UsersTypeRepository usersTypeRepository;
	
	@Autowired
	public UsersTypeService(UsersTypeRepository usersTypeRepository) {
		super();
		this.usersTypeRepository = usersTypeRepository;
	}
	
	public List<UsersType> getAll() {
		return usersTypeRepository.findAll();
	}
}
