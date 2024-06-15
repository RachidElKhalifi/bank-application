package com.corsoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoSpring.dao.CcDao;
import com.corsoSpring.helper.ResponseManager;
import com.corsoSpring.model.ContoCorrente;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class CcServiceImp implements CcService {
	
	@Autowired
	private CcDao ccDao;
	
	@Override
	public List<ContoCorrente> getCc() {

		return (List<ContoCorrente>) ccDao.findAll();
	}

	@Override
	public ContoCorrente getCcById(int id) {
		Optional<ContoCorrente> ccOptional = ccDao.findById(id);
		if(ccOptional.isPresent())
			return ccOptional.get();
		else return null;
	}

	@Override
	public ContoCorrente salva(ContoCorrente cc) {
		return ccDao.save(cc);		
		
	}

	@Override
	public ObjectNode cancella(int id) {
		Optional<ContoCorrente> ccOptional = ccDao.findById(id);
		if(ccOptional.isPresent()) {
			ccDao.delete(ccOptional.get());
			ResponseManager man = new ResponseManager(200,"Banca cancellata con successo");
			return  man.getResponse();
		} 
		ResponseManager man = new ResponseManager(404,"Banca non trovata!");
		return man.getResponse();
		
	}


}
