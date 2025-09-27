package com.luv2code.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.jobportal.services.UsersService;

@Controller class JobPostActivityController {
	
	private final UsersService usersService;
	
	@Autowired
	public JobPostActivityController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	
	@GetMapping("/dashboard")
    public String searchJobs(Model model) {

        Object currentUserProfile = usersService.getCurrentUserProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("username", currentUsername);
        }

        model.addAttribute("user", currentUserProfile);

        return "dashboard";
    }
	
	
}
