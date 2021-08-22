package com.cibertec.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Rol;
import com.cibertec.entidad.Usuario;
import com.cibertec.repositorio.RolRepositorio;
import com.cibertec.repositorio.UsuarioRepositorio;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UsuarioSeguridadServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private RolRepositorio rolRepositorio;
	
	@Autowired  
	private HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UserDetails userDetails = null;
		
		try {
			Usuario objUsuario = usuarioRepositorio.findByLogin(login);
			log.info("========|||=========== " + objUsuario.getLogin());

			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			List<Rol> lstRol = rolRepositorio.listaRolesPorLogin(login);
			for (Rol x : lstRol) {
				roles.add(new SimpleGrantedAuthority(x.getNombre()));
			}

			log.info("========|||=========== " + lstRol);

			userDetails = new User(objUsuario.getLogin(), objUsuario.getPassword(), roles);
		
			request.getSession().setAttribute("objUsuario", userDetails);
		} catch (IndexOutOfBoundsException e) {
			throw new UsernameNotFoundException("Wrong username");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Database Error");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Unknown Error");
		}

		return userDetails;
	}

}
