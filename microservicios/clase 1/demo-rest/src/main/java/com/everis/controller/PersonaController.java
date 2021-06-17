package com.everis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.model.Persona;
import com.everis.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    
	@Autowired
	private IPersonaService service;
	
    @GetMapping
    public void saludar() {
    	this.service.saludar();
    }
	
	/*@GetMapping(produces = "application/xml")
    public Persona saludarPersona() {
    	Persona per = new Persona();
    	per.setIdPersona(1);
    	per.setNombres("Everis");
    	return per;
    }
	
	@GetMapping
    public String despedir() {
    	return this.service.despedir();
    }*/
	
	@GetMapping("/despedir")
    public String despedir() {
    	return this.service.despedir();
    }
	
	@GetMapping(value ="/listar", produces = "application/xml")
    public List<Persona> listarPersonas() {
    	return this.service.listarPersonas();
    }
}
