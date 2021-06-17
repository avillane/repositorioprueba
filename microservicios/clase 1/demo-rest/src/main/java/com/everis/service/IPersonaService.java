package com.everis.service;

import java.util.List;

import com.everis.model.Persona;

public interface IPersonaService {
 public void saludar();
 public String despedir();
 public List<Persona> listarPersonas();
}
