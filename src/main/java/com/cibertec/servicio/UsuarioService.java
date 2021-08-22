package com.cibertec.servicio;

import com.cibertec.entidad.Usuario;

public interface UsuarioService {

	public abstract Usuario buscaPorLogin(String login);

}
