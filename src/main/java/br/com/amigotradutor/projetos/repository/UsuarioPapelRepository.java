package br.com.amigotradutor.projetos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.projetos.model.UsuarioPapel;
import br.com.amigotradutor.projetos.model.UsuarioPapelId;

public interface UsuarioPapelRepository extends CrudRepository<UsuarioPapel,UsuarioPapelId> {
	
	Iterable<UsuarioPapel> findByUsuarioPapelIdUsuarioId(long usuarioId);
	
}
