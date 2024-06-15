package com.corsoSpring.dao;

import org.springframework.data.repository.CrudRepository;

import com.corsoSpring.model.ContoCorrente;

public interface CcDao extends CrudRepository<ContoCorrente, Integer> {

}
