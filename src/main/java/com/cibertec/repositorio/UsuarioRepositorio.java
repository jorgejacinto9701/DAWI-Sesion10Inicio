package com.cibertec.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	public abstract Usuario findByLogin(String login);
	
	
}
