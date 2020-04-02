package br.com.produtoToy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtoToy.domains.Produto;
import br.com.produtoToy.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository repo  ;
	
	@GetMapping(value ="{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Produto> produtoOptional = repo.findById(id);
		if(produtoOptional.isPresent()) {
			return ResponseEntity.ok(produtoOptional);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
	
	@GetMapping(value ="like/{descricao}")
	public ResponseEntity<?> findByDescricao(@PathVariable String descricao){
		List<Produto> produtos = repo.findByDescricaoContainingIgnoreCase(descricao);
		if(produtos.size()>0) {
			return ResponseEntity.ok(produtos);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}

}
