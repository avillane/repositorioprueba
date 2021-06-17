package com.everis.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.model.Greeting;
import com.everis.service.IGreetingService;

@RestController
@RequestMapping(value="/greeting")
public class GreetingController {
	
	@Autowired
	private IGreetingService service;
	
	@GetMapping
	public Greeting greeting(@RequestParam(value="name", defaultValue= "World") String name ) {
		return service.Greetings(name);
	}

}
