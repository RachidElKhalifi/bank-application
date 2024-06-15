package com.corsoSpring.service;

import java.util.List;

import com.corsoSpring.model.ContoCorrente;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface CcService {
	
	public List<ContoCorrente> getCc();	
	public ContoCorrente getCcById(int id);
	public ContoCorrente salva(ContoCorrente cc);
	public ObjectNode cancella(int id);

}
