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
import br.com.amigotradutor.projetos.service.PapelService;

@RestController
public class PapelController {

	@Autowired
	private PapelService service;
	
	@GetMapping("/papeis")
	public List<Papel> getAllPapel(){
		return service.getAll();
	}
	
	@GetMapping("/papeis/{id}")
	public Papel getAllPapel(@PathVariable long id){
		return service.getOne(id);
	}
	
	@PostMapping("/papeis")
	public Papel addPapel(@RequestBody Papel papel) throws ValidacaoNegocioException{
		service.add(papel);
		return papel;
	}
	
	@PutMapping("/papeis/{id}")
	public Papel updatePapel(@PathVariable long id, @RequestBody Papel papel) throws ValidacaoNegocioException{
		
		service.update(id,papel);
		return papel;
	}
	
	@DeleteMapping("/papeis/{id}")
	public void deletePapel(@PathVariable long id) throws ValidacaoNegocioException{
		service.delete(id);
	}
}
