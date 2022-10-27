package com.example.demo.entities;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "destino")
public class Destino {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "destino_estado")
	private String estado;
	
	@Column(name = "destino_cidade")
	private String cidade;
	
	
	@Column(name = "destino_ida")
	private String ida;
	
	@Column(name = "destino_volta")
	private String volta;
	
   
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;
	
	

	
	
	
	
	
	
	
	
	public Destino() {
		super();
	}





	public Destino(Long id, String nome, String estado, String cidade, String ida, String volta) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.ida = ida;
		this.volta = volta;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}





	public String getCidade() {
		return cidade;
	}





	public void setCidade(String cidade) {
		this.cidade = cidade;
	}





	public String getIda() {
		return ida;
	}





	public void setIda(String ida) {
		this.ida = ida;
	}





	public String getVolta() {
		return volta;
	}





	public void setVolta(String volta) {
		this.volta = volta;
	}





	public Cliente getCliente() {
		return cliente;
	}





	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}











	
	
	
	
}
