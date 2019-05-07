package br.com.amigotradutor.projetos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.projetos.model.Usuario;
import br.com.amigotradutor.projetos.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return service.getAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable long id) throws ValidacaoNegocioException{
		return service.getOne(id);
	}
	
	@PostMapping("/usuarios")
	public Usuario novoUsuario(@RequestBody Usuario u) throws ValidacaoNegocioException{
		service.add(u);
		return u;
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario updateUsuario(@PathVariable long id, @RequestBody Usuario u) throws ValidacaoNegocioException {
		service.update(id, u);
		return u;
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void deleteUsuario(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
