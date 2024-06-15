package com.corsoSpring.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "citta")
public class Citta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
		
	@OneToMany (
			cascade = CascadeType.REFRESH,
			fetch = FetchType.LAZY,
			mappedBy = "citta",
			orphanRemoval = false
	)
	@JsonBackReference
	private List<Persona> listaPersone = new ArrayList<Persona>();

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Persona> getListaPersone() {
		return listaPersone;
	}

	
	 
}
