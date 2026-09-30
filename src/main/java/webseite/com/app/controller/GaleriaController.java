package webseite.com.app.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

import webseite.com.app.model.Galeria;
import webseite.com.app.service.GaleriaService;

@Controller
@RequestMapping("/galeria")
public class GaleriaController {

    private final GaleriaService galeriaService;

    public GaleriaController(GaleriaService galeriaService) {
        this.galeriaService = galeriaService;
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("Titulo", "Listado de la Galería");
        model.addAttribute("galerias", galeriaService.listar());
        return "galeria/listar";
    }

    @GetMapping({"/nuevo", "/registrar"})
    public String nuevo(Model model) {
        Galeria g = new Galeria();
        g.setFechaCreacion(Date.valueOf(LocalDate.now()));
        g.setFechaModificacion(Date.valueOf(LocalDate.now()));
        g.set_condicion(1);
        model.addAttribute("Titulo", "Registrar Galería");
        model.addAttribute("accion", "guardar");
        model.addAttribute("galeria", g);
        return "galeria/frmgaleria";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated @ModelAttribute("galeria") Galeria galeria,
                          BindingResult result, Model model, RedirectAttributes ra) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            model.addAttribute("Titulo", "Registrar Galería");
            model.addAttribute("accion", "guardar");
            model.addAttribute("error", errores);
            return "galeria/frmgaleria";
        }
        if (galeria.getFechaCreacion() == null) {
            galeria.setFechaCreacion(Date.valueOf(LocalDate.now()));
        }
        galeria.setFechaModificacion(Date.valueOf(LocalDate.now()));
        galeriaService.save(galeria);
        ra.addFlashAttribute("success", "Galería registrada correctamente.");
        return "redirect:/galeria/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Galeria g = galeriaService.get(id).orElse(null);
        if (g == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró la galería con ID: " + id);
            return "redirect:/galeria/listar";
        }
        model.addAttribute("Titulo", "Editar Galería");
        model.addAttribute("accion", "actualizar");
        model.addAttribute("galeria", g);
        return "galeria/frmgaleria";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @Validated @ModelAttribute("galeria") Galeria galeria,
                             BindingResult result, Model model, RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("Titulo", "Editar Galería");
            model.addAttribute("accion", "actualizar");
            return "galeria/frmgaleria";
        }
        galeria.setId_archivo(id);
        galeria.setFechaModificacion(Date.valueOf(LocalDate.now()));
        galeriaService.update(galeria);
        ra.addFlashAttribute("success", "Galería actualizada correctamente.");
        return "redirect:/galeria/listar";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Galeria g = galeriaService.get(id).orElse(null);
        if (g == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró la galería con ID: " + id);
            return "redirect:/galeria/listar";
        }
        model.addAttribute("Titulo", "Detalle de la Galería");
        model.addAttribute("galeria", g);
        return "galeria/ver";
    }
}
