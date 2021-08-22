package com.cibertec.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entidad.Opcion;
import com.cibertec.entidad.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Integer>{

	
	@Query("Select r from Rol r, UsuarioHasRol u where  r.idRol = u.rol.idRol and  u.usuario.login = :var_login")
	public abstract List<Rol> listaRolesPorLogin(@Param("var_login")String login);
	
	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where p.idOpcion = pr.opcion.idOpcion and  pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.login = :var_login")
	public abstract List<Opcion> listaOpcionesPorLogin(@Param("var_login") String login);

	
}
