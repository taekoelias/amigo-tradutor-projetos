package br.com.amigotradutor.projetos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Equipe equipe;

	private long idCapitulo;
	
	@ManyToOne
	private SituacaoProjeto situacao;
	
	@Temporal(TemporalType.DATE)
	private Date prazoConclusao;
	
	public Projeto() {
	}

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

	public long getIdCapitulo() {
		return idCapitulo;
	}

	public void setIdCapitulo(long idCapitulo) {
		this.idCapitulo = idCapitulo;
	}

	public SituacaoProjeto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProjeto situacao) {
		this.situacao = situacao;
	}

	public Date getPrazoConclusao() {
		return prazoConclusao;
	}

	public void setPrazoConclusao(Date prazoConclusao) {
		this.prazoConclusao = prazoConclusao;
	}
	
}
