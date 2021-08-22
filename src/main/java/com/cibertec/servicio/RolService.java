package com.cibertec.servicio;

import java.util.List;

import com.cibertec.entidad.Opcion;
import com.cibertec.entidad.Rol;

public interface RolService {

	public abstract List<Opcion> listaOpcionesPorLogin(String login);
	public abstract List<Rol> listaRolesPorLogin(String login);

}
