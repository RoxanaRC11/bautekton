/*package webseite.com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webseite.com.app.model.Usuario;
import webseite.com.app.repository.UsuarioRepository; 
/*
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { 
		// Buscar al usuario en la base de datos real usando el email que ingresaron en el Login
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		
		if (usuarioOpt.isEmpty()) { 
			throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
		}
		
		Usuario usuario = usuarioOpt.get();
		
		String rol = (usuario.getId_usuario() == 1) ? "ADMIN" : "USER";
		
		// Se devuelve un objeto User oficial de Spring Security con los datos reales de tu tabla		
		return User.builder()
				.username(usuario.getEmail())
				.password(usuario.getContrasena()) // Debe estar encriptada con BCrypt en la BD
				.roles(rol)
				.disabled(!usuario.getEstado().equalsIgnoreCase("activo")) // Si no está activo, bloquea el login
				.build();
	}
}
*/