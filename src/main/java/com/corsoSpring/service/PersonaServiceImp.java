package com.corsoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoSpring.dao.PersonaDao;
import com.corsoSpring.helper.ResponseManager;
import com.corsoSpring.model.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public List<Persona> getPersone() { 
		return (List<Persona>)personaDao.findAll(); 
	}

	@Override
	public Persona getPersonaById(int id) {
		Optional<Persona> personaOptional = personaDao.findById(id);
		if(personaOptional.isPresent())
			return personaOptional.get();
		else return null;
	}

	@Override
	public Persona salva(Persona persona) {
		return personaDao.save(persona);		
	}

	@Override
	public void cancella(Persona persona) {
		personaDao.delete(persona);		
		
	}

	@Override
	public ObjectNode cancella(int id) {
		Optional<Persona> personaOptional = personaDao.findById(id);
		if(personaOptional.isPresent()) {
			personaDao.delete(personaOptional.get());
			ResponseManager man = new ResponseManager(200,"Banca cancellata con successo");
			return  man.getResponse();
		} 
		ResponseManager man = new ResponseManager(404,"Banca non trovata!");
		return man.getResponse();
		
	}



}
