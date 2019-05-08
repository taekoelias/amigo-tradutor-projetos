package br.com.amigotradutor.projetos.validator;

import java.util.List;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.projetos.model.Usuario;
import br.com.amigotradutor.projetos.repository.UsuarioRepository;

public class UsuarioValidator implements BaseValidator<Usuario, Long>{

	UsuarioRepository repository;
	
	public UsuarioValidator(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Usuario obj) throws ValidacaoNegocioException {
		
		if (ValidatorUtil.isEmpty(obj) || ValidatorUtil.isEmpty(obj.getNome()) 
				|| ValidatorUtil.isEmpty(obj.getNome().getPrimeiroNome()) || ValidatorUtil.isEmpty(obj.getNome().getUltimoNome()) 
				|| ValidatorUtil.isEmpty(obj.getEmail()) || ValidatorUtil.isEmpty(obj.getSenha()) 
				|| ValidatorUtil.isEmpty(obj.getApelido()) || ValidatorUtil.isEmpty(obj.getDataNascimento()))
			throw new ValidacaoNegocioException("Os dados obrigatórios do usuário não foram preenchidos.");
		
	}

	public void duplicated(Usuario obj) throws ValidacaoNegocioException {
		
		requiredField(obj);
		
		List<Usuario> usuarioBD = repository.findByEmailOrApelido(obj.getEmail().trim().toLowerCase(), obj.getApelido().trim());
		
		if (usuarioBD != null) {
			
			for (Usuario u : usuarioBD) {
				if (u.getId() != obj.getId()) {
					if (u.getEmail().equalsIgnoreCase(obj.getEmail()))
						throw new EntidadeUnicaExistenteException("Já existe um usuário cadastrado com o mesmo e-mail.");
					else
						throw new EntidadeUnicaExistenteException("Já existe um usuário cadastrado com o mesmo apelido.");
				}
			}
		}
	}
	
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O usuário informado não foi encontrado na base de dados.");
		
	}
	
}
