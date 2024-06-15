package com.corsoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoSpring.dao.BancaDao;
import com.corsoSpring.helper.ResponseManager;
import com.corsoSpring.model.Banca;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class BancaServiceImp implements BancaService {

	@Autowired
	private BancaDao bancaDao;
	
	@Override
	public List<Banca> getBanche() { 
		return (List<Banca>) bancaDao.findAll();
		 
	}

	@Override
	public Banca getBancaById(int id) {
		Optional<Banca> bancaOptional = bancaDao.findById(id);
		if(bancaOptional.isPresent())
			return bancaOptional.get();
		else return null;	}
	
	@Override
	public Banca salva(Banca banca) {
		return bancaDao.save(banca);
		
	}
	
	@Override
	public void cancella(Banca banca) {
		bancaDao.delete(banca);
	}
 
	@Override
	public ObjectNode cancella(int id) {
		Optional<Banca> bancaOptional = bancaDao.findById(id);
		if(bancaOptional.isPresent()) {
			bancaDao.delete(bancaOptional.get());
			ResponseManager man = new ResponseManager(200,"Banca cancellata con successo");
			return  man.getResponse();
		} 
		ResponseManager man = new ResponseManager(404,"Banca non trovata!");
		return man.getResponse();
		
	}
}
