/*package webseite.com.app.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import webseite.com.app.model.Usuario;
import webseite.com.app.service.UsuarioService;



@Controller
@SessionAttributes("usuario")
@RequestMapping({ "/Usuario", "/usuario" })
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/registrar")
	public String index(Model model) {
		Usuario miusuario = new Usuario();
		miusuario.setContrasena("");
		miusuario.setEmail("");
		miusuario.setEstado("");
		miusuario.setFechaRegistro(null);
		miusuario.setFechaActualizacion(null);
		miusuario.set_condicion(0); 
		
		model.addAttribute("usuario", miusuario);
		model.addAttribute("titulo", "Formulario de Usuarios");
		return "usuario/frmusuariorox";

	}

	/*@PostMapping("/registrar")// Cambiando para coincidir con la intencion de envio
	public String prozessusuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model modelo, SessionStatus status) {
	if(result.hasErrors()) {
		modelo.addAttribute("titulo", "Resultado Formulario");
		return "usuario/frmusuario"; // Si hay errores, regresa al formulario
	}
	// Aqui iria tu logica de guardado: usuarioServicios.savee(usuario);
	logger.info("Usuario recibido: " + usuario.getEmail());
	status.setComplete(); //Limpia la sesion una vez terminado el proceso
	return "redirect:/usuario/registrar"; //Redirige para evitar re envios de formulario
		
	}Esto es explicacion de la IA*/

	/*@PostMapping("/registrar")
	public String procesar(@Validated Usuario usuario, BindingResult result, Model modelo, SessionStatus status) {
		if (result.hasErrors()) {
			Map<String,String> errores=new HashMap<>();
			result.getFieldErrors().forEach(error->{
				errores.put(error.getField(), error.getDefaultMessage());
			});
			
			modelo.addAttribute("usuario", usuario);
			modelo.addAttribute("Titulo", "Formulaio Usuario");
			modelo.addAttribute("error", errores);
			return "usuario/frmusuariorox";
		}
		
		
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("Titulo", "Formulaio Usuario");
		return "usuario/resultado";
	}
	//Metodo Listar del CRUD que conexta con la Base de Datos
	@GetMapping({"/", "/listar"})
	public String listar(Model model) {
		model.addAttribute("Titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarioService.listar());
		return "usuario/listar";
	}
	
	//Nuevo Registro (Formulario)
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
	Usuario u = new Usuario();
	u.setFechaRegistro(Date.valueOf(LocalDate.now()));
	u.setFechaActualizacion(Date.valueOf(LocalDate.now()));
	u.setEstado("habilitado");
	u.set_condicion(1); //Activo por defecto
	
	model.addAttribute("Titulo", "Registrar Usuario");
	model.addAttribute("accion", "guardar");
	model.addAttribute("usuario", u);
	return "usuario/frmusuariorox";
	}
	
	// ✅ GUARDAR (Crear)
    @PostMapping("/guardar")
    public String guardar(@Validated Usuario usuario,
                          BindingResult result,
                          Model model,
                          RedirectAttributes ra) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));

            model.addAttribute("Titulo", "Registrar Usuario");
            model.addAttribute("accion", "guardar");
            model.addAttribute("usuario", usuario);
            model.addAttribute("error", errores);
            return "usuario/frmusuariorox";
        }

        // set de fechas si llegan null
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(Date.valueOf(LocalDate.now()));
        }
        usuario.setFechaActualizacion(Date.valueOf(LocalDate.now()));

        usuarioService.save(usuario);
        ra.addFlashAttribute("success", "Usuario registrado correctamente.");
        return "redirect:/usuario/listar";
    }

    // ✅ EDITAR (Formulario)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        Usuario u = usuarioService.get(id).orElse(null);
        if (u == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el usuario con ID: " + id);
            return "redirect:/usuario/listar";
        }

        model.addAttribute("Titulo", "Editar Usuario");
        model.addAttribute("accion", "actualizar");
        model.addAttribute("usuario", u);
        return "usuario/frmusuariorox";
    }

    // ✅ ACTUALIZAR (Editar)
    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id") Integer id,
                             @Validated Usuario usuario,
                             BindingResult result,
                             Model model,
                             RedirectAttributes ra) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));

            model.addAttribute("Titulo", "Editar Usuario");
            model.addAttribute("accion", "actualizar");
            model.addAttribute("usuario", usuario);
            model.addAttribute("error", errores);
            return "usuario/frmusuariorox";
        }

        Usuario existente = usuarioService.get(id).orElse(null);
        if (existente == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el usuario con ID: " + id);
            return "redirect:/usuario/listar";
        }

        // Asegurar ID correcto
        usuario.setId_usuario(id);

        // Mantener fechaRegistro anterior si no llega
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(existente.getFechaRegistro());
        }
        usuario.setFechaActualizacion(Date.valueOf(LocalDate.now()));

        usuarioService.update(usuario);
        ra.addFlashAttribute("success", "Usuario actualizado correctamente.");
        return "redirect:/usuario/listar";
    }

    // ✅ ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            usuarioService.delete(id);
            ra.addFlashAttribute("success", "Usuario eliminado correctamente.");
        } catch (Exception ex) {
            logger.error("Error eliminando usuario {}", id, ex);
            ra.addFlashAttribute("errorMsg", "No se pudo eliminar (puede tener dependencias).");
        }
        return "redirect:/usuario/listar";
    }

    // ✅ VER DETALLE (Opcional)
package webseite;


    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        Usuario u = usuarioService.get(id).orElse(null);
        if (u == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el usuario con ID: " + id);
            return "redirect:/usuario/listar";
        }
        model.addAttribute("Titulo", "Detalle de Usuario");
        model.addAttribute("usuario", u);
        return "usuario/ver";
    }
	}
}
*/