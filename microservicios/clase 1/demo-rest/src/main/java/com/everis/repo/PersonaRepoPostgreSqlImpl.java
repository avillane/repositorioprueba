package com.everis.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.everis.model.Persona;

@Repository
@Qualifier("personaPostgreSql")
public class PersonaRepoPostgreSqlImpl implements IPersonaRepo {

	@Override
	public void saludar() {
		System.out.print("Hola Everis");
		
	}
	
	@Override
	public String despedir() {
		return "Bye Everis";
	}
	
	@Override
	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = new Persona();
		persona.setIdPersona(1);
		persona.setNombres("Everis");
		personas.add(persona);
		return personas;
	}
}
