package webseite.com.app.controller;

import java.sql.Date;
import java.time.LocalDate;
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

import webseite.com.app.model.Orden;
import webseite.com.app.service.OrdenService;

@Controller
@RequestMapping("/orden")
public class OrdenController {

    private final OrdenService ordenService;
    private static final Logger logger = LoggerFactory.getLogger(OrdenController.class);

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("Titulo", "Listado de Órdenes");
        model.addAttribute("ordenes", ordenService.listar());
        return "orden/listar";
    }

    @GetMapping("/registrar")
    public String registrar(Model model) {
        Orden orden = new Orden();
        orden.set_condicion(1);
        model.addAttribute("orden", orden);
        model.addAttribute("Titulo", "Registrar Orden");
        return "orden/frmorden";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Orden orden = ordenService.buscarPorId(id);
        if (orden == null) {
            ra.addFlashAttribute("error", "No se encontró la orden con ID: " + id);
            return "redirect:/orden/listar";
        }
        model.addAttribute("orden", orden);
        model.addAttribute("Titulo", "Editar Orden");
        return "orden/frmorden";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated @ModelAttribute("orden") Orden orden,
                          BindingResult result,
                          Model model,
                          RedirectAttributes ra) {
        boolean nueva = orden.getId_orden() == null;
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            model.addAttribute("Titulo", nueva ? "Registrar Orden" : "Editar Orden");
            model.addAttribute("error", errores);
            return "orden/frmorden";
        }
        if (orden.getFechaInicio() == null) {
            orden.setFechaInicio(Date.valueOf(LocalDate.now()));
        }
        ordenService.guardar(orden);
        ra.addFlashAttribute("success", nueva ? "Orden creada correctamente." : "Orden actualizada correctamente.");
        return "redirect:/orden/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            ordenService.eliminar(id);
            ra.addFlashAttribute("success", "Orden eliminada correctamente.");
        } catch (Exception ex) {
            logger.error("Error eliminando orden {}", id, ex);
            ra.addFlashAttribute("error", "No se puede eliminar la orden.");
        }
        return "redirect:/orden/listar";
    }
}
