package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Usuario;

public interface UsuarioService {
	public Usuario save(Usuario usuario);
	public Optional<Usuario>get(Integer id);
	public void update(Usuario usuario);
	public void delete(Integer id);
	public Optional<Usuario>listar();

}
