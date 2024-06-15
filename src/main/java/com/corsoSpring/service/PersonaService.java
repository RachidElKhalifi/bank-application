package com.corsoSpring.service;

import java.util.List;

import com.corsoSpring.model.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface PersonaService {
	
	public List<Persona> getPersone();	
	public Persona getPersonaById(int id);
	public void cancella(Persona persona);
	public Persona salva(Persona persona);
	public ObjectNode cancella(int id); 

}
