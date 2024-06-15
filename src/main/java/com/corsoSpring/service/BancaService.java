package com.corsoSpring.service;

import java.util.List;

import com.corsoSpring.model.Banca;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface BancaService {

	public List<Banca> getBanche();	
	public Banca getBancaById(int id);
	public Banca salva(Banca banca);
	public void cancella(Banca banca); 
	public ObjectNode cancella(int id); 
	
}
