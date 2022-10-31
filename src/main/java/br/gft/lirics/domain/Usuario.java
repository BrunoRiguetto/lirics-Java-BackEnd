package br.gft.lirics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Table(name = "\"users\"")
@Data
public class Usuario implements Serializable{
	private static final long serialVersionUID = 5028154602127426877L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "\"id\"")
	private Long id;
	
	//@Column(name = "\"name\"")
	private String nome;
	
	private String cpf;
	
	private String email;
	
	//@Column(name = "\"password\"")
	private String senha;
}
