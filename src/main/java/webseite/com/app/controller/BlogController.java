package webseite.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    /**
     * Maneja la URL /blog (cuando pulsas "Blog" en el menú).
     * Muestra una página índice con los 3 blogs disponibles.
     */
    @GetMapping
    public String verBlog() {
        return "blog/blogIndex";   // ← antes era "redirect:/blog/monumentoEs"
    }

    @GetMapping("/carmelitas")
    public String verCarmelitas() {
        return "blog/blogcarmelitas";
    }

    @GetMapping("/monumentoEs")
    public String verMonumentoEs() {
        return "blog/blogmonumentoEs";
    }

    @GetMapping("/colonial")
    public String verColonial() {
        return "blog/blogcolonial";
    }
}