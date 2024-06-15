package com.corsoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoSpring.dao.FilialeDao;
import com.corsoSpring.helper.ResponseManager;
import com.corsoSpring.model.Filiale;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class FilialeServiceImp implements FilialeService {
	
	@Autowired
	private FilialeDao filialeDao;
	
	@Override
	public List<Filiale> getFiliali() {

		return (List<Filiale>) filialeDao.findAll();
	}

	@Override
	public Filiale getFilialeById(int id) {
		Optional<Filiale> filialeOptional = filialeDao.findById(id);
		if(filialeOptional.isPresent())
			return filialeOptional.get();
		else return null;
	}
	@Override
	public Filiale salva(Filiale filiale) {
	return 	filialeDao.save(filiale);		
		
	}

	@Override
	public ObjectNode cancella(int id) {
		Optional<Filiale> filialeOptional = filialeDao.findById(id);
		if(filialeOptional.isPresent()) {
			filialeDao.delete(filialeOptional.get());
			ResponseManager man = new ResponseManager(200,"Banca cancellata con successo");
			return  man.getResponse();
		} 
		ResponseManager man = new ResponseManager(404,"Banca non trovata!");
		return man.getResponse();
		
	}



	
}
