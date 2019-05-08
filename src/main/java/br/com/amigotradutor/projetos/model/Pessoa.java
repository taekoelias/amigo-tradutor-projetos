package br.com.amigotradutor.projetos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Embedded
	private NomePessoa nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public Pessoa() {
	}

	public Pessoa(long id, NomePessoa nome, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}
	
	public NomePessoa getNome() {
		return nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setNome(NomePessoa nome) {
		this.nome = nome;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return this.nome.toString();
	}
}
