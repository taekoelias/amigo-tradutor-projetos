package br.com.amigotradutor.projetos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Equipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private List<MembroEquipe> membros;
	
	public Equipe() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<MembroEquipe> getMembros() {
		return membros;
	}

	public void setMembros(List<MembroEquipe> membros) {
		this.membros = membros;
	}
	
}
