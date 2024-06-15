package com.corsoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoSpring.dao.CittaDao;
import com.corsoSpring.helper.ResponseManager;
import com.corsoSpring.model.Citta;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class CittaServiceImp implements CittaService {
	
	@Autowired
	private CittaDao cittaDao;

	@Override
	public List<Citta> getCitta() {
		return (List<Citta>) cittaDao.findAll();
	}

	@Override
	public Citta getCittaById(int id) {
		Optional<Citta> cittaOptional = cittaDao.findById(id);
		if(cittaOptional.isPresent())
			return cittaOptional.get();
		else return null;
	}
			

	@Override
	public Citta salva(Citta citta) {
		return cittaDao.save(citta);	
	}

	@Override
	public void cancella(Citta citta) {
		cittaDao.delete(citta);
	}

	@Override
	public ObjectNode cancella(int id) {
		Optional<Citta> cittaOptional = cittaDao.findById(id);
		if(cittaOptional.isPresent()) {
			cittaDao.delete(cittaOptional.get());
			ResponseManager man = new ResponseManager(200,"Banca cancellata con successo");
			return  man.getResponse();
		} 
		ResponseManager man = new ResponseManager(404,"Banca non trovata!");
		return man.getResponse();
		
	}


	
	

}
