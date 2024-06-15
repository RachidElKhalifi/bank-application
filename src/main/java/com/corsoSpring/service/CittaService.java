package com.corsoSpring.service;

import java.util.List;

import com.corsoSpring.model.Citta;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface CittaService {
	
	//Definisce l'interfaccia di servizio per le operazioni che posso svolgere sulle città
	
	public List<Citta> getCitta();	
	public Citta getCittaById(int id);
	public Citta salva(Citta citta);
	public void cancella(Citta citta);
	public ObjectNode cancella(int id); 

}
