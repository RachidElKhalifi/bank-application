package com.corsoSpring.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name ="banche")
public class Banca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nome")
	private String nome;
	
	
	@OneToMany (
			cascade = CascadeType.REFRESH,
			fetch = FetchType.LAZY,
			mappedBy = "banca",
			orphanRemoval = false
	)
	@JsonBackReference
	private List<Filiale> listaFiliali = new ArrayList<Filiale>();

	public List<Filiale> getListaFiliali() {
		return listaFiliali;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
	}

}
