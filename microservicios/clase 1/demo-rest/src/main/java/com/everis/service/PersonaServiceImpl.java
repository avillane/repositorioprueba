package com.everis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.everis.model.Persona;
import com.everis.repo.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	@Qualifier("personaMySql")
	private IPersonaRepo repo;
	
	@Override
	public void saludar() {
		this.repo.saludar();
	}

	@Override
	public String despedir() {
		return this.repo.despedir();
	}
	
	@Override
	public List<Persona> listarPersonas() {
		return this.repo.listarPersonas();
	}

}
