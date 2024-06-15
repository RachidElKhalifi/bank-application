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
import jakarta.persistence.Table;

@Entity
@Table(name = "conticorrenti")
public class ContoCorrente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "giacenza")
	private double giacenza;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinColumn(name ="intestatario_id", referencedColumnName = "id")
	private Persona intestatario;
	
	@Column(name = "numero")
	private String numeroConto;
	
	@ManyToOne( cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="filiale_id", referencedColumnName = "id")
	private Filiale filiale;

	public double getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(double giacenza) {
		this.giacenza = giacenza;
	}

	public Persona getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(Persona intestatario) {
		this.intestatario = intestatario;
	}

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}

}
