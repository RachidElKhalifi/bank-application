package com.corsoSpring.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "filiali")
public class Filiale { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name; 

	@ManyToOne (cascade = CascadeType.REFRESH,fetch =  FetchType.EAGER)
	@JoinColumn(name = "banca_id", referencedColumnName = "id")
	private Banca banca;
	
	@ManyToOne (cascade = CascadeType.REFRESH,fetch =  FetchType.EAGER)
	@JoinColumn(name = "citta_id", referencedColumnName = "id")
	private Citta citta;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name ="direttore_id", referencedColumnName = "id")
	private Persona direttore;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public Citta getCitta() {
		return citta;
	}
	public void setCitta(Citta citta) {
		this.citta = citta;
	}
	public Persona getDirettore() {
		return direttore;
	}
	public void setDirettore(Persona direttore) {
		this.direttore = direttore;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	

}
