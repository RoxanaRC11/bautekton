package webseite.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webseite.com.app.model.Detalleorden;
import webseite.com.app.service.DetalleordenService;

@Controller
@RequestMapping("/detalleorden")
public class DetalleordenController {

    private final DetalleordenService detalleordenService;

    public DetalleordenController(DetalleordenService detalleordenService) {
        this.detalleordenService = detalleordenService;
    }

    @GetMapping("/frmdetalleorden")
    public String index(Model model) {
        Detalleorden detalleorden = new Detalleorden();
        detalleorden.setDescripcion("");
        detalleorden.setEstatus("");
        detalleorden.setTarea("");
        detalleorden.setTipo("");
        model.addAttribute("detalleorden", detalleorden);
        return "detalleorden/frmdetalleorden";
    }

    @PostMapping("/frmdetalleorden")
    public String procesar(@Validated @ModelAttribute("detalleorden") Detalleorden detalleorden,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "detalleorden/frmdetalleorden";
        }
        // PENDIENTE: aquí debe llamarse al método real de persistencia de DetalleordenService.
        // No lo inventamos porque aún no se proporcionó la interfaz/implementación del servicio.
        model.addAttribute("success", "Datos validados correctamente. Falta enlazar el método de guardado del servicio.");
        return "detalleorden/frmdetalleorden";
    }
}
