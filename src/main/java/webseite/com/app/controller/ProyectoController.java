
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

import webseite.com.app.model.Proyecto;
import webseite.com.app.service.ProyectoService;

@Controller
@SessionAttributes("proyecto")
@RequestMapping({"/proyecto", "/Proyecto"})
public class ProyectoController {
	
	@Autowired
	public ProyectoService proyectoServicios;
	
	public final Logger Logger=LoggerFactory.getLogger(Proyecto.class);
	
	@GetMapping("/proyecto")
	public String index(Model modelo) {
		Proyecto proyecto = new Proyecto();
		proyecto.setDescripcion("");
		proyecto.setFechaInicio(null);
		proyecto.setFechaFin(null);
		//proyecto.setId_cliente(null );
		proyecto.setId_proyecto(null);
		proyecto.setImagenprincipal("");
		modelo.addAttribute("miproyecto","proyecto");
		modelo.addAttribute("Titulo", "Formulario del Proyecto");
		return "proyecto/frmproyecto";
	}
	@PostMapping("/frmproyecto")
	public String prozessproyecto(BindingResult result, Model model, SessionStatus status) {
		return "proyecto/frmproyecto";
	}

}
