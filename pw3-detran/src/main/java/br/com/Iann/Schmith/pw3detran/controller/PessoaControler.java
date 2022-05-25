package br.com.Iann.Schmith.pw3detran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Iann.Schmith.pw3detran.entity.Pessoa;
import br.com.Iann.Schmith.pw3detran.repositoy.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaControler {
	
	@Autowired
	private PessoaRepository repository;
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(){
		pessoas = repository.findAll();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Integer id) {
		Optional<Pessoa> resultado =  repository.findById(id);
			if(resultado.isPresent()) {
				ResponseEntity.noContent().build();
			}
		return ResponseEntity.ok(resultado.get());
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa pessoa) {
		repository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		
		boolean existe = repository.existsById(id);
			if(existe) {
				repository.save(pessoa);
				return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
			}
		return ResponseEntity.noContent().build();
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> delete(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
