package br.com.amigotradutor.projetos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome"}))
public class Papel {

	public static final long PAPEL_USUARIO = 1;
	
	public static final long PAPEL_ADMIN = 2;
	
	public static final long PAPEL_GERENTE = 3;
	
	public static final long PAPEL_TRADUTOR = 4;
	
	public static final long PAPEL_REVISOR = 5;
	
	public static final long PAPEL_EDITOR = 6;
	
	public static final long PAPEL_REV_EDICAO = 7;
	
	@Id
	private long id;
	
	private String nome;
	
	private String descricao;
	
	public Papel() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Papel other = (Papel) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public static Papel getPapelUsuario(){
		Papel usuario = new Papel();
		usuario.setId(PAPEL_USUARIO);
		return usuario;
	}
	
	public static Papel getPapelAdmin(){
		Papel admin = new Papel();
		admin.setId(PAPEL_ADMIN);
		return admin;
	}
	
	public static Papel getPapelTradutor(){
		Papel admin = new Papel();
		admin.setId(PAPEL_TRADUTOR);
		return admin;
	}
}
