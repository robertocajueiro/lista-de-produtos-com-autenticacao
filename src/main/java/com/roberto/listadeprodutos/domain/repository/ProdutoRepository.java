package com.roberto.listadeprodutos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.listadeprodutos.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
