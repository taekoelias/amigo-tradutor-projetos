package br.com.amigotradutor.projetos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.amigotradutor.projetos.model.Pessoa;

@NoRepositoryBean
public interface PessoaBaseRepository<T extends Pessoa> extends CrudRepository<T, Long> {

}
