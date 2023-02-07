package com.roberto.listadeprodutos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.roberto.listadeprodutos.domain.model.Produto;
import com.roberto.listadeprodutos.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("http://localhost:4200")
public class ProdutoController {
	
	private final ProdutoRepository repository;
	
	@Autowired
	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar( @RequestBody Produto produto ){
        return repository.save(produto);
    }
    
    @GetMapping
	public List<Produto> obterTodos(){
		return repository.findAll();
	}
    
    @GetMapping("{id}")
    public Produto acharPorId(@PathVariable Long id) {
    	return repository
    			.findById(id)
    			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") );
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
    	 repository
    	 .findById(id)
    	 .map(produto -> {
    		repository.delete(produto);
    		return Void.TYPE;
    	 })
    	 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") );
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody Produto ProdutoAtualizado) {
    	repository
    	 .findById(id)
	   	 .map(produto -> {
	   		produto.setDescricao(ProdutoAtualizado.getDescricao());
	   		produto.setCodigo(ProdutoAtualizado.getCodigo());
	   		return repository.save(produto);
	   	 })
	   	 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") );
	    }
    
	

}
