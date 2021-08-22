package com.cibertec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.entidad.Opcion;
import com.cibertec.entidad.Rol;
import com.cibertec.entidad.Usuario;
import com.cibertec.servicio.RolService;
import com.cibertec.servicio.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private UsuarioService usuarioService;

	
	@RequestMapping("/")
	public String login() {
		return "intranetLogin";
	}
	
	@RequestMapping("/loginNoExiste")
	public String login(HttpServletRequest request) {
		request.setAttribute("mensaje", "El usuario no existe");
		return "intranetLogin";
	}
	
	@RequestMapping(value = { "/home"})
	public String home( HttpSession session) {

		UserDetails objsalida = (UserDetails) session.getAttribute("objUsuario");
		
		List<Opcion> lstOpciones = rolService.listaOpcionesPorLogin(objsalida.getUsername());
		List<Rol> lstRoles = rolService.listaRolesPorLogin(objsalida.getUsername());
		Usuario objUsusarioLogeado = usuarioService.buscaPorLogin(objsalida.getUsername());
		
		session.setAttribute("objUsuario", objUsusarioLogeado);
		session.setAttribute("objMenus", lstOpciones);
		session.setAttribute("objRoles",lstRoles);
		
		return "intranetHome";
	}
	

	@RequestMapping("/loginSalir")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();

		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "intranetLogin";

	}

}
