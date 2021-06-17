package com.everis.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.everis.model.Persona;

@Repository
@Qualifier("personaMySql")
public class PersonaRepoMySqlImpl implements IPersonaRepo {

	@Override
	public void saludar() {
		System.out.print("Hola Nttd");
		
	}

	@Override
	public String despedir() {
		return "Bye Nttd";
	}
	
	@Override
	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = new Persona();
		persona.setIdPersona(2);
		persona.setNombres("Nttd");
		personas.add(persona);
		return personas;
	}
}
