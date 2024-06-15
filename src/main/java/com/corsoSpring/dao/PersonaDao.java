package com.corsoSpring.dao;

import org.springframework.data.repository.CrudRepository;

import com.corsoSpring.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Integer> {

}
