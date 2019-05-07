package br.com.amigotradutor.projetos.repository;

import java.util.List;

import br.com.amigotradutor.projetos.model.Usuario;

public interface UsuarioRepository extends PessoaBaseRepository<Usuario> {
	
	List<Usuario> findByPapeisId(long papelId);
	
	List<Usuario> findByEmailOrApelido(String email,String apelido);
}
