package br.com.amigotradutor.projetos.model;

import javax.persistence.Embeddable;

@Embeddable
public class NomePessoa {

	private String primeiroNome;
	
	private String ultimoNome;

	public NomePessoa() {
	}
	
	public NomePessoa(String primeiroNome, String ultimoNome) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	@Override
	public String toString() {
		return primeiroNome + " " + ultimoNome;
	}
}
