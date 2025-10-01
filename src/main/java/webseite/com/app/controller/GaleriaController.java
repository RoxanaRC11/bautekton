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

import webseite.com.app.model.Galeria;
import webseite.com.app.service.GaleriaService;

@Controller
@SessionAttributes
@RequestMapping({"/galeria", "/Galeria"})
public class GaleriaController {
	
	@Autowired
	private GaleriaService galeriaServicio; 
	
	public final Logger LOGGER=LoggerFactory.getLogger(Galeria.class);
	
	@GetMapping("/frmgaleria")
	public String index(Model modelo) { // aqui se referiria a ingresar al formulario o que se refiere con index?, es el index del home?
	 Galeria galeria =  new Galeria();
	 galeria.setDescripcion("");
	 galeria.setFechaCreacion(null);
	 galeria.setFechaModificacion(null);
	 galeria.getId_archivo();
	 //galeria.setId_proyecto(null);
	 galeria.setNombre("");
	 galeria.setRuta("");
	 galeria.setTipo("");
	 modelo.addAttribute("galeria", galeria);
	 modelo.addAttribute("Titulo","Formulario de la Galeria");
	 return "galeria/frmgaleria";
	}
	
	@PostMapping("/frmgaleria")
	public String prozessGaleria(BindingResult result, Model modelo, SessionStatus status) {
	return "galeria/frmgaleria";
	}
}