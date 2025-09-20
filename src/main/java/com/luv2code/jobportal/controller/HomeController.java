package com.luv2code.jobportal.controller;
/*
 Controller → Handles HTTP requests/responses (entry point of the API).
 Controller → receives requests, calls the Service, returns responses (the Controller in MVC).
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/*@GetMapping just maps a URL to a method. When a request comes to / (the root URL), call the home() method.*/
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
/*Spring uses a ViewResolver (commonly InternalResourceViewResolver or ThymeleafViewResolver) to turn "index" into a real template file. So the ViewResolver takes the string "index" and looks for the actual file (like index.html) in the correct folder.*/
