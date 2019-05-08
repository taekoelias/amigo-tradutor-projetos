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
import br.com.amigotradutor.projetos.model.Papel;
import br.com.amigotradutor.projetos.model.UsuarioPapel;
import br.com.amigotradutor.projetos.model.UsuarioPapelId;
import br.com.amigotradutor.projetos.service.UsuarioPapelService;

@RestController
public class UsuarioPapelController {

	@Autowired
	private UsuarioPapelService usuarioPapelService;
	
	@GetMapping("/usuarios/{id}/papeis")
	public List<UsuarioPapel> getPapeisUsuario(@PathVariable long id) throws ValidacaoNegocioException{
		return usuarioPapelService.getAllPapelByUsuario(id);
	}
	
	@PostMapping("/usuarios/{id}/papeis")
	public UsuarioPapel addUsuarioPapel(@PathVariable long id, @RequestBody UsuarioPapel up) throws ValidacaoNegocioException{
		
		up.getUsuarioPapelId().setUsuarioId(id);
		usuarioPapelService.add(up);
		
		return up;
	}
	
	@PutMapping("/usuarios/{id}/papeis/{idPapel}")
	public UsuarioPapel ativaPapeisUsuario(@PathVariable long id, @PathVariable long idPapel, @RequestBody UsuarioPapel up) throws ValidacaoNegocioException{
		
		up.getUsuarioPapelId().setUsuarioId(id);
		up.getUsuarioPapelId().setPapelId(idPapel);
		usuarioPapelService.update(up.getUsuarioPapelId(),up);
		
		return up;
	}
	
	@DeleteMapping("/usuarios/{id}/papeis/{idPapel}")
	public void deleteUsuarioPapel(@PathVariable long id, @PathVariable long idPapel) throws ValidacaoNegocioException{
		usuarioPapelService.delete(new UsuarioPapelId(id, idPapel));
	}
}
