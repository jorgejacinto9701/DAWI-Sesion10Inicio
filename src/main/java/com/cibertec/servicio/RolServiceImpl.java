package com.cibertec.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Opcion;
import com.cibertec.entidad.Rol;
import com.cibertec.repositorio.RolRepositorio;
@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepositorio rolRepositorio;
	
	@Override
	public List<Opcion> listaOpcionesPorLogin(String login) {
		return rolRepositorio.listaOpcionesPorLogin(login);
	}

	@Override
	public List<Rol> listaRolesPorLogin(String login) {
		return rolRepositorio.listaRolesPorLogin(login);
	}


}
