package br.com.amigotradutor.projetos.validator;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.projetos.model.UsuarioPapel;
import br.com.amigotradutor.projetos.model.UsuarioPapelId;
import br.com.amigotradutor.projetos.repository.UsuarioPapelRepository;

public class UsuarioPapelValidator implements BaseValidator<UsuarioPapel,UsuarioPapelId>{

	UsuarioPapelRepository repository;
	
	public UsuarioPapelValidator(UsuarioPapelRepository repository) {
		this.repository = repository;
	}

	@Override
	public void requiredField(UsuarioPapel obj) throws ValidacaoNegocioException {
		
		if (obj == null || obj.getUsuarioPapelId() == null 
				|| (obj.getUsuarioPapelId().getUsuarioId() == 0 && obj.getUsuarioPapelId().getPapelId() == 0))
			throw new ValidacaoNegocioException("Os dados da vinculação do usuário com o papel não foram preenchidos.");
	}
	
	public void notExists(UsuarioPapelId id) throws ValidacaoNegocioException {
		
		if (id == null)
			throw new ValidacaoNegocioException("Os dados da vinculação do usuário com o papel não foram preenchidos.");
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O vinculação do usuário com o papel informado não foi encontrado na base de dados.");
			
	}

	@Override
	public void duplicated(UsuarioPapel obj) throws ValidacaoNegocioException {
		
	}
}
