package br.com.amigotradutor.projetos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MembroEquipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Equipe equipe;
	
	@ManyToOne
	private UsuarioPapel usuarioPapel;
	
	private boolean responsavel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public boolean isResponsavel() {
		return responsavel;
	}

	public void setResponsavel(boolean responsavel) {
		this.responsavel = responsavel;
	}

	public UsuarioPapel getUsuarioPapel() {
		return usuarioPapel;
	}

	public void setUsuarioPapel(UsuarioPapel usuarioPapel) {
		this.usuarioPapel = usuarioPapel;
	}
	
}
