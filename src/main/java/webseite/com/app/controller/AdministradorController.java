package webseite.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

    // =========================================================
    // PÁGINA PRINCIPAL
    // =========================================================
    @GetMapping({
        "/",
        "/principal",
        "/home",
        "/inicio"
    })
    public String home() {

        return "principal/frmprincipal";
    }


    // =========================================================
    // POLÍTICA DE PRIVACIDAD
    // =========================================================
    @GetMapping("/politica-privacidad")
    public String mostrarPoliticaPrivacidad() {

        return "principal/politica-privacidad";
    }


    // =========================================================
    // ACCESO DENEGADO
    // =========================================================
    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {

        return "acceso-denegado";
    }
}