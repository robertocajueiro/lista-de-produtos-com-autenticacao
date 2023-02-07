package com.roberto.listadeprodutos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roberto.listadeprodutos.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
