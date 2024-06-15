package com.corsoSpring.service;

import java.util.List;

import com.corsoSpring.model.Filiale;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface FilialeService {
	
	public List<Filiale> getFiliali();	
	public Filiale getFilialeById(int id);
	public ObjectNode cancella(int id);
	public Filiale salva(Filiale filiale);


}
