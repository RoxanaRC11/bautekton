package webseite.com.app.service;

import java.util.List;
import java.util.Optional;
import webseite.com.app.model.Usuario;

public interface UsuarioService {
	Usuario save(Usuario usuario);
	Optional<Usuario>get(Integer id);
	void update(Usuario usuario);
	void delete(Integer id);
	//public Optional<Usuario>listar();
	List<Usuario>listar(); //Cambiado a List para manejar multiples usuarios 
	/*Agregar el metodo para filtrar por condicion en la interfaz*/
	Optional<Usuario>encontrarUser(int Codigo);
	Optional<Usuario>encontrarUser(String Email);
	Optional<Usuario>buscarUser(String Apellido);
	Optional<Usuario>listaPorCondicion(int _condicion);

}
