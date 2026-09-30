package webseite.com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webseite.com.app.model.Clientes;
import webseite.com.app.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;
    private static final Logger logger = LoggerFactory.getLogger(ClientesController.class);

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("Titulo", "Listado de Clientes");
        model.addAttribute("listado", clientesService.listar());
        return "clientes/listar";
    }

    @GetMapping({"/nuevo", "/registrar"})
    public String nuevo(Model model) {
        Clientes c = new Clientes();
        c.setTipo_cliente("REGULAR");
        c.setEstado("PENDIENTE");
        c.set_condicion(1);
        model.addAttribute("Titulo", "Registrar Cliente");
        model.addAttribute("accion", "guardar");
        model.addAttribute("clientes", c);
        return "clientes/frmcliente";
    }

    @PostMapping({"/guardar", "/registrarbd"})
    public String guardar(@Validated @ModelAttribute("clientes") Clientes clientes,
                          BindingResult result,
                          Model model,
                          RedirectAttributes ra) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            model.addAttribute("Titulo", "Registrar Cliente");
            model.addAttribute("accion", "guardar");
            model.addAttribute("error", errores);
            return "clientes/frmcliente";
        }
        clientesService.save(clientes);
        ra.addFlashAttribute("success", "Cliente guardado correctamente.");
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Clientes c = clientesService.get(id).orElse(null);
        if (c == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el cliente con ID: " + id);
            return "redirect:/clientes/listar";
        }
        model.addAttribute("Titulo", "Editar Cliente");
        model.addAttribute("accion", "actualizar");
        model.addAttribute("clientes", c);
        return "clientes/frmcliente";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @Validated @ModelAttribute("clientes") Clientes clientes,
                             BindingResult result,
                             Model model,
                             RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("Titulo", "Editar Cliente");
            model.addAttribute("accion", "actualizar");
            return "clientes/frmcliente";
        }
        if (clientesService.get(id).isEmpty()) {
            ra.addFlashAttribute("errorMsg", "No se encontró el cliente con ID: " + id);
            return "redirect:/clientes/listar";
        }
        clientes.setId_cliente(id);
        clientesService.update(clientes);
        ra.addFlashAttribute("success", "Cliente actualizado correctamente.");
        return "redirect:/clientes/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            clientesService.delete(id);
            ra.addFlashAttribute("success", "Cliente eliminado correctamente.");
        } catch (Exception ex) {
            logger.error("Error eliminando cliente {}", id, ex);
            ra.addFlashAttribute("error", "No se pudo eliminar el cliente; puede tener dependencias.");
        }
        return "redirect:/clientes/listar";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Clientes c = clientesService.get(id).orElse(null);
        if (c == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el cliente con ID: " + id);
            return "redirect:/clientes/listar";
        }
        model.addAttribute("Titulo", "Detalle de Cliente");
        model.addAttribute("clientes", c);
        return "clientes/ver";
    }
}
