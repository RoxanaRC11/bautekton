package webseite.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import webseite.com.app.model.Detalleorden;
import webseite.com.app.service.ClientesService;
import webseite.com.app.service.DetalleordenService;

@Controller
@RequestMapping({"/detalleorden", "/Detalleorden"})
public class DetalleordenController {
	
	@Autowired
	private DetalleordenService  detalleordenServicios;
	
	@GetMapping("/frmdetalleorden")
	public String index(Model model) {
		
	Detalleorden detalleorden = new Detalleorden();
	
	detalleorden.setId_detalleOrden(02);
	detalleorden.setDescripcion("");
	detalleorden.setEstatus("");
	detalleorden.setFechaInicio(null); 
	detalleorden.setFechaEntrega(null);
	//detalleorden.setId_orden(null);
	//detalleorden.getId_proyecto();
	detalleorden.setTarea("");
	detalleorden.setTipo(" ");
	model.addAttribute(detalleorden);
	model.addAttribute(null);
	return null;
	}
	
	@PostMapping("/frmdetalleorden")
	public String procesardetalleorden(BindingResult result, Model modelo, SessionStatus Status) {
		return "detalleorden/frmdetalleorden";
	}
}
