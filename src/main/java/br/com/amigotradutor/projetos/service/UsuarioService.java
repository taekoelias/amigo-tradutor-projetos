package br.com.amigotradutor.projetos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.service.CrudService;
import br.com.amigotradutor.projetos.model.Papel;
import br.com.amigotradutor.projetos.model.Usuario;
import br.com.amigotradutor.projetos.repository.UsuarioRepository;
import br.com.amigotradutor.projetos.validator.UsuarioValidator;

@Service
public class UsuarioService implements CrudService<Usuario,Long>{

	@Autowired
	private UsuarioRepository dao;
	
	public List<Usuario> getAll(){
		List<Usuario> usuarios = new ArrayList<>();
		
		dao.findAll().forEach(usuarios::add);
		return usuarios;
	}
	
	public Usuario getOne(Long usuarioId) throws ValidacaoNegocioException{
		UsuarioValidator validator = new UsuarioValidator(dao);
		validator.notExists(usuarioId);
		
		return dao.findById(usuarioId).get();
	}
	
	public void add(Usuario u) throws ValidacaoNegocioException {
		
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.requiredField(u);
		validator.duplicated(u);
		
		u.setEmail(u.getEmail().trim().toLowerCase());
		u.setPapeis(new ArrayList<Papel>());
		u.getPapeis().add(Papel.getPapelUsuario());
		u = dao.save(u);
	}
	
	@Override
	public void update(Long id,Usuario u) throws ValidacaoNegocioException {
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.notExists(id);
		validator.requiredField(u);
		validator.duplicated(u);
		
		u.setId(id);
		u.setEmail(u.getEmail().trim().toLowerCase());
		
		u = dao.save(u);
	}

	@Override
	public void delete(Long u) throws ValidacaoNegocioException {
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.notExists(u);
		
		dao.deleteById(u);
	}

}
