package br.com.amigotradutor.projetos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.projetos.model.Pessoa;
import br.com.amigotradutor.projetos.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> getAllPessoa(){
		
		List<Pessoa> pessoas = new ArrayList<>();
		repository.findAll().forEach(pessoas::add);
		
		return pessoas;
	}
	
	public void addPessoa(Pessoa p){
		repository.save(p);
	}
	
}
