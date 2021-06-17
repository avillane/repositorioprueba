package com.everis.repo;

import java.util.List;

import com.everis.model.Persona;

public interface IPersonaRepo {
	
  void saludar();
  
  String despedir();
  
  List<Persona> listarPersonas();
}
