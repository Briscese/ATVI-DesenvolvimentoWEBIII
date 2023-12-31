package com.autobots.automanager.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String nomeSocial;
	@Column
	private Date dataNascimento;
	@Column
	private Date dataCadastro;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;
	
	
	@OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Telefone> telefones = new ArrayList<>();
	
	public void addDocumento(Documento documento) {
		documentos.add(documento);
		documento.setCliente(this);
	}

	public void removeDocumento(Documento documento) {
		documentos.remove(documento);
		documento.setCliente(null);
	}

	public void addTelefone(Telefone telefone) {
	    if (telefones == null) {
	        telefones = new ArrayList<>();
	    }
	    telefones.add(telefone);
	    telefone.setCliente(this);
	}


	public void removeTelefone(Telefone telefone) {
		telefones.remove(telefone);
		telefone.setCliente(null);
	}

}