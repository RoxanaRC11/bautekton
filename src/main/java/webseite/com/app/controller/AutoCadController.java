package webseite.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autocad")
public class AutoCadController {

    @GetMapping("/revit3D")
    public String verRevit3D() {
        return "AutoCad/revit3D";
    }

    @GetMapping("/autocad3D")
    public String verAutocad3D() {
        return "AutoCad/autocad3D";
    }

    @GetMapping("/revitInt")
    public String verRevitInt() {
        return "AutoCad/revitInt";
    }
}
