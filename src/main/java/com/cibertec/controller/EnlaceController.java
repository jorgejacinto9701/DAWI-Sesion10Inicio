package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EnlaceController {


	@RequestMapping("/verRegistroCliente")
	public String verRegistraCliente() {	return "intranetRegistroCliente";	}
	
	@RequestMapping("/verRegistroMarca")
	public String verRegistraMarca() {	return "intranetRegistroMarca";	}
	
	@RequestMapping("/verRegistroProveedor")
	public String verRegistraProveedor() {	return "intranetRegistroProveedor";	}
	
	@RequestMapping("/verRegistroProducto")
	public String verRegistraProducto() {	return "intranetRegistroProducto";	}

	@RequestMapping("/verRegistroReclamo")
	public String verRegistraReclamo() {	return "intranetRegistroReclamo";	}
	
	@RequestMapping("/verRegistroSede")
	public String verRegistroSede() {	return "intranetRegistroSede";	}
	
	@RequestMapping("/verRegistroUsuario")
	public String verRegistroUsuario() {	return "intranetRegistroUsuario";	}
	
	@RequestMapping("/verRegistroTipoReclamo")
	public String verRegistroTipoReclamo() {	return "intranetRegistroTipoReclamo";	}
	
	@RequestMapping("/verRegistroPais")
	public String verRegistroPais() {	return "intranetRegistroPais";	}
	
	
	//cruds
	@RequestMapping("/verCrudCliente")
	public String verCrudCliente() {	return "intranetCrudCliente";	}
	
	@RequestMapping("/verCrudMarca")
	public String verCrudMarca() {	return "intranetCrudMarca";	}
	
	@RequestMapping("/verCrudProveedor")
	public String verCrudProveedor() {	return "intranetCrudProveedor";	}
	
	@RequestMapping("/verCrudProducto")
	public String verCrudProducto() {	return "intranetCrudProducto";	}

	@RequestMapping("/verCrudReclamo")
	public String verCrudReclamo() {	return "intranetCrudReclamo";	}
	
	@RequestMapping("/verCrudSede")
	public String verCrudSede() {	return "intranetCrudSede";	}
	
	@RequestMapping("/verCrudUsuario")
	public String verCrudUsuario() {	return "intranetCrudUsuario";	}
	
	@RequestMapping("/verCrudTipoReclamo")
	public String verCrudTipoReclamo() {	return "intranetCrudTipoReclamo";	}
	
	@RequestMapping("/verCrudPais")
	public String verCrudPais() {	return "intranetCrudPais";	}
	
	
}
