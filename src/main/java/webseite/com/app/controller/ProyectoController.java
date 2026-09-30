package webseite.com.app.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webseite.com.app.model.Proyecto;
import webseite.com.app.service.ClientesService;
import webseite.com.app.service.ProyectoService;

@Controller
@SessionAttributes("proyecto")
@RequestMapping({"/proyecto", "/Proyecto"})
public class ProyectoController {
	
	@Autowired
	public ProyectoService proyectoService;
	
	@Autowired
	public ClientesService clientesService; 
	
	private final Logger logger = LoggerFactory.getLogger(ProyectoController.class);
		
	public ProyectoController(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}

	//LISTAR 
	@GetMapping({"/" , "/listar"})
	public String listar(Model modelo) {
		modelo.addAttribute("Titulo", "Listado de Proyectos");
		modelo.addAttribute("proyecto", proyectoService.listar());
		return "proyecto/listar";
	}
	
	//NUEVO (Formulario)
	@GetMapping("/nuevo")
	public String nuevo(Model modelo) { 
		Proyecto p = new Proyecto();
		p.setFechaInicio(Date.valueOf(LocalDate.now()));
		p.setFechaFin(Date.valueOf(LocalDate.now()));
		p.setEstado("habilitado");
		p.setUbicacion(null);
		p.setImagenprincipal(null);
		p.set_condicion(1);
		
		modelo.addAttribute("Titulo", "Registrar Proyecto");
		modelo.addAttribute("accion", "guardar");
		modelo.addAttribute("proyecto", p);
		return "proyecto/frmproyecto";
	}
	
	//GUARDAR (Crear - versión registrarbd)
	@PostMapping("/registrarbd")
	public String registrarbd(@Validated Proyecto proyecto,
			BindingResult result,
			Model model,
			RedirectAttributes ra) {
		
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
			
			model.addAttribute("Titulo", "Registrar Proyecto");
			model.addAttribute("accion", "guardar");
			model.addAttribute("proyecto", proyecto);
			model.addAttribute("error", errores);
			return "proyecto/frmproyecto";
		}

		//Set de fechas si llegan null
		if (proyecto.getFechaInicio() == null) {
			proyecto.setFechaInicio(Date.valueOf(LocalDate.now()));
		}
		if (proyecto.getFechaFin() == null) {
			proyecto.setFechaFin(Date.valueOf(LocalDate.now()));
		}
		
		proyectoService.save(proyecto);
		ra.addFlashAttribute("success", "Proyecto registrado correctamente.");
		return "redirect:/proyecto/listar";
	}

	//Guardar (Crear - versión guardar)
	@PostMapping ("/guardar")
	public String guardar(@Validated Proyecto proyecto,
					BindingResult result,
					Model modelo,
					RedirectAttributes ra) {
						
		if (result.hasErrors()) { 
			Map<String , String> errores = new HashMap<>();
			result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
			
			modelo.addAttribute("Titulo", "Registrar Proyecto");
			modelo.addAttribute("accion", "guardar");
			modelo.addAttribute("proyecto", proyecto);
			modelo.addAttribute("error", errores);
			return "proyecto/frmproyecto";
		}
		
		//set de fechas si llegan null
		if (proyecto.getFechaInicio() == null) { 
			proyecto.setFechaInicio(Date.valueOf(LocalDate.now()));
		}
		if (proyecto.getFechaFin() == null) {
			proyecto.setFechaFin(Date.valueOf(LocalDate.now()));
		}
		
		proyectoService.save(proyecto);
		ra.addFlashAttribute("success", "Proyecto registrado correctamente.");
		return "redirect:/proyecto/listar";
	}
			
	//Editar (Formulario)
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model modelo, RedirectAttributes ra) { 
		Proyecto p = proyectoService.get(id).orElse(null);
		if (p == null) {
			ra.addFlashAttribute("errorMsg", "Proyecto no encontrado.");
			return "redirect:/proyecto/listar";
		}
		modelo.addAttribute("Titulo", "Editar Proyecto");
		modelo.addAttribute("accion", "actualizar");
		modelo.addAttribute("proyecto", p);
		return "proyecto/frmproyecto";
	}
	
	//ACTUALIZAR (Editar)
	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable("id") Integer id,
			@Validated Proyecto proyecto,
			BindingResult result,
			Model modelo,
			RedirectAttributes ra) {
		
		if (result.hasErrors()) { 
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
			
			modelo.addAttribute("Titulo", "Editar Proyecto");
			modelo.addAttribute("accion", "actualizar");
			modelo.addAttribute("proyecto", proyecto);
			modelo.addAttribute("error", errores);
			return "proyecto/frmproyecto";
		}
		
		Proyecto existente = proyectoService.get(id).orElse(null);
		if (existente == null) { 
			ra.addFlashAttribute("errorMsg", "No se encontró el proyecto con ID: " + id);
			return "redirect:/proyecto/listar";
		}
		
		// Asegurar ID correcto
		proyecto.setId_proyecto(id);
		
		// Mantener fechaInicio anterior si no llega
		if (proyecto.getFechaInicio() == null) { 
			proyecto.setFechaInicio(existente.getFechaInicio());
		}
		if (proyecto.getFechaFin() == null) {
			proyecto.setFechaFin(Date.valueOf(LocalDate.now()));
		}
		
		proyectoService.update(proyecto);
		ra.addFlashAttribute("success", "Proyecto actualizado correctamente.");
		return "redirect:/proyecto/listar";
	}
	
	// ELIMINAR
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id, RedirectAttributes ra) { 
		try { 
			proyectoService.delete(id);
			ra.addFlashAttribute("success", "Proyecto eliminado correctamente.");
		} catch (Exception ex) { 
			logger.error("Error eliminando proyecto {}", id, ex);
			ra.addFlashAttribute("errorMsg", "No se puede eliminar (puede tener dependencias).");
		}
		return "redirect:/proyecto/listar";
	}
	
	//VER DETALLE
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable("id") Integer id, Model modelo, RedirectAttributes ra) { 
		Proyecto p = proyectoService.get(id).orElse(null);
		if (p == null) { 
			ra.addFlashAttribute("errorMsg", "No se encontró el proyecto con ID: " + id);
			return "redirect:/proyecto/listar";
		}
		modelo.addAttribute("Titulo", "Detalle de Proyecto");
		modelo.addAttribute("proyecto", p);
		return "proyecto/ver";
	}
}