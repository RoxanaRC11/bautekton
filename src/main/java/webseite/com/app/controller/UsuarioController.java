package webseite.com.app.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import webseite.com.app.model.Usuario;
import webseite.com.app.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    // Registro público
    @GetMapping("/registrar")
    public String registrar(Model model) {
        Usuario u = new Usuario();
        u.setFechaRegistro(Date.valueOf(LocalDate.now()));
        u.setFechaActualizacion(Date.valueOf(LocalDate.now()));
        u.setEstado("habilitado");
        u.set_condicion(1);
        model.addAttribute("usuario", u);
        model.addAttribute("Titulo", "Registrar Usuario");
        return "usuario/frmusuariorox";
    }

    @PostMapping("/registrarbd")
    public String registrarbd(@Validated @ModelAttribute("usuario") Usuario usuario,
                              BindingResult result, Model model, RedirectAttributes ra) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
            model.addAttribute("Titulo", "Registrar Usuario");
            model.addAttribute("error", errores);
            return "usuario/frmusuariorox";
        }
        usuario.setFechaRegistro(usuario.getFechaRegistro() == null ? Date.valueOf(LocalDate.now()) : usuario.getFechaRegistro());
        usuario.setFechaActualizacion(Date.valueOf(LocalDate.now()));
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioService.save(usuario);
        ra.addFlashAttribute("success", "Usuario registrado correctamente. Ya puede iniciar sesión cuando se conecte la autenticación a la BD.");
        return "redirect:/principal";
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("Titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuario/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Usuario u = new Usuario();
        u.setFechaRegistro(Date.valueOf(LocalDate.now()));
        u.setFechaActualizacion(Date.valueOf(LocalDate.now()));
        u.setEstado("habilitado");
        u.set_condicion(1);
        model.addAttribute("Titulo", "Registrar Usuario");
        model.addAttribute("accion", "guardar");
        model.addAttribute("usuario", u);
        return "usuario/editar";
    }

    @PostMapping("/guardar")
    public String guardar(@Validated @ModelAttribute("usuario") Usuario usuario,
                          BindingResult result, Model model, RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("Titulo", "Registrar Usuario");
            model.addAttribute("accion", "guardar");
            return "usuario/editar";
        }
        usuario.setFechaRegistro(usuario.getFechaRegistro() == null ? Date.valueOf(LocalDate.now()) : usuario.getFechaRegistro());
        usuario.setFechaActualizacion(Date.valueOf(LocalDate.now()));
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioService.save(usuario);
        ra.addFlashAttribute("success", "Usuario registrado correctamente.");
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Usuario u = usuarioService.get(id).orElse(null);
        if (u == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el usuario con ID: " + id);
            return "redirect:/usuario/listar";
        }
        // No se envía el hash como contraseña editable.
        u.setContrasena("");
        model.addAttribute("Titulo", "Editar Usuario");
        model.addAttribute("accion", "actualizar");
        model.addAttribute("usuario", u);
        return "usuario/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @Validated @ModelAttribute("usuario") Usuario usuario,
                             BindingResult result, Model model, RedirectAttributes ra) {
        Usuario existente = usuarioService.get(id).orElse(null);
        if (existente == null) {
            ra.addFlashAttribute("errorMsg", "No se encontró el usuario con ID: " + id);
            return "redirect:/usuario/listar";
        }
        if (result.hasErrors()) {
            model.addAttribute("Titulo", "Editar Usuario");
            model.addAttribute("accion", "actualizar");
            return "usuario/editar";
        }
        usuario.setId_usuario(id);
        usuario.setFechaRegistro(existente.getFechaRegistro());
        usuario.setFechaActualizacion(Date.valueOf(LocalDate.now()));
        if (usuario.getContrasena() == null || usuario.getContrasena().isBlank()) {
            usuario.setContrasena(existente.getContrasena());
        } else {
            usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        }
        usuarioService.update(usuario);
        ra.addFlashAttribute("success", "Usuario actualizado correctamente.");
        return "redirect:/usuario/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            usuarioService.delete(id);
            ra.addFlashAttribute("success", "Usuario eliminado correctamente.");
        } catch (Exception ex) {
            logger.error("Error eliminando usuario {}", id, ex);
            ra.addFlashAttribute("errorMsg", "No se pudo eliminar; puede tener dependencias.");
        }
        return "redirect:/usuario/listar";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model, RedirectAttributes ra) {
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
