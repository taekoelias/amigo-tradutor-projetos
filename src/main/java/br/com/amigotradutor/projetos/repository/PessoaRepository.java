package br.com.amigotradutor.projetos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.projetos.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
