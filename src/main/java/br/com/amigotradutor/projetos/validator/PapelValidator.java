package br.com.amigotradutor.projetos.validator;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.projetos.model.Papel;
import br.com.amigotradutor.projetos.repository.PapelRepository;

public class PapelValidator implements BaseValidator<Papel,Long>{

	PapelRepository repository;
	
	public PapelValidator(PapelRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Papel obj) throws ValidacaoNegocioException {
		
		if (obj == null || obj.getNome() == null || obj.getDescricao() == null)
			throw new ValidacaoNegocioException("Os dados obrigatórios do papel não foram preenchidos.");
		
	}

	public void duplicated(Papel obj) throws ValidacaoNegocioException {
		
		requiredField(obj);
		
		Papel papelBD = repository.findByNome(obj.getNome());
		
		if (papelBD != null && papelBD.getId() != obj.getId()) {
			throw new EntidadeUnicaExistenteException("Já existe um papel cadastrado com o mesmo nome.");
		}
	}
	
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O papel informado não foi encontrado na base de dados.");
		
	}
	
}
