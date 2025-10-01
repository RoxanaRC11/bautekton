package webseite.com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import webseite.com.app.model.Clientes;
import webseite.com.app.service.ClientesService;

@Controller
@SessionAttributes("clientes")
@RequestMapping({"/clientes", "/Clientes"})
public class ClientesController {
	
	@Autowired
	private ClientesService clientesServicios; //aqui se refiere al mismo servicio que aparece en la clase ClienteServicio?
	
	
	public final Logger lOGGER=LoggerFactory.getLogger(Clientes.class); //y para que creamos esta constante?
	
	
	@GetMapping("/registrar")// que pasa cuando el cliente ya se registro pero quiere escribir su login?
	public String index(Model model) {
		Clientes miclientes = new Clientes();
		miclientes.setNombres("Juan");
		miclientes.setApellidos("Alcazar Vela");
		miclientes.setDNI("123564");
		miclientes.setDireccion("Alameda Vieja 13, 65 Madrid");//porque hay un error aqui?
		miclientes.setId_cliente(null);
		//miclientes.setId_usuario(null);
		miclientes.setTipo_cliente("");
		model.addAttribute("clientes", miclientes);
	    model.addAttribute("Titulo", "Formulario Clientes");
	  
		return "clientes/registrar";
	}

	@PostMapping("/frmclientes")
	public String prozessclientes(BindingResult result, Model modelo, SessionStatus status) {
		return "clientes/frmclientes";
		
	}
}
