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

import webseite.com.app.model.Usuario;
import webseite.com.app.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
@RequestMapping({ "/Usuario", "/usuario" })
public class UsuarioController {

	@Autowired
	private UsuarioService UsuarioServicios;

	public final Logger logger = LoggerFactory.getLogger(Usuario.class);

	@GetMapping("/registrar")
	public String index(Model model) {
		Usuario usuario = new Usuario();
		usuario.setContrasena("");
		usuario.setEmail("");
		usuario.setEstado("");
		usuario.setFechaRegistro(null);
		usuario.setFechaActualizacion(null);
		return "usuario/registrar";

	}

	@PostMapping("/frmusuario")
	public String prozessusuario(BindingResult result, Model modelo, SessionStatus status) {
		return "usuario/frmusuario";
	}

}
