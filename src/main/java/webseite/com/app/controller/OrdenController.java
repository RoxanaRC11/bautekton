package webseite.com.app.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import webseite.com.app.model.Orden;
import webseite.com.app.service.OrdenService;

@Controller
@RequestMapping({"/orden", "/Orden"})
@SessionAttributes("ordenController")
public class OrdenController {
	
	@Autowired
	private  OrdenService Ordenservicios;
	
	private Object loggerFactory;
	public final Logger LOGGER=	LoggerFactory.getLogger(Orden.class);
	
	@GetMapping("/frmorden")
	public String index(Model modelo) {
		Orden orden = new Orden();
		orden.setId_orden(null);
		//orden.setId_proyecto(null);
		orden.setDescripcion("");
		orden.setFechaEntrega(null);
		orden.getFechaInicio();
		orden.setEstado("");
		modelo.addAttribute("miorden/orden");
		modelo.addAttribute("Titulo", "Formulario de la Orden");
		return "orden/frmorden";
	}
	
	@PostMapping
	public String prozessorden(BindingResult result, Model model, SessionStatus status) {
		return "orden/frmorden";
		}
	}


