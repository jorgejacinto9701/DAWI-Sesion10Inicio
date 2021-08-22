package com.cibertec.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Usuario;
import com.cibertec.repositorio.UsuarioRepositorio;
@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public Usuario buscaPorLogin(String login) {
		return usuarioRepositorio.findByLogin(login);
	}

}
