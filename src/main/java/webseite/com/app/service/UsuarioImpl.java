package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import webseite.com.app.model.Usuario;
import webseite.com.app.repository.UsuarioRepository;

/*Impleentacion de la interfaz UsuarioService para la gestion de usuarios*/

@Service
public class UsuarioImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@Override
	@Transactional //Sin readOnly: Permite Insert/UPDATE
	public Usuario save(Usuario usuario) {
		// Al guardar, podemos asegurar una condición por defecto si es necesario
        return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)//Optimiza la lectura de un usuario por ID
	public Optional<Usuario> get(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional //sin readOnly: Permite actualizar datos. 	En Spring Data JPA, save() actua como update si el objeto ya tiene un ID existente
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	@Transactional // Sin readOnly: Permite eliminar registros de la base de datos por ID
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
		
	}

	/*@Override
	public Optional<Usuario> listar() {
		return Optional.empty();}*/

	@Override
    @Transactional(readOnly = true)//Recupera todos los registros de la tabla usuario
    public List<Usuario> listar() {
	// Recupera todos los registros de la tabla usuario
        return usuarioRepository.findAll();
    }
	

	@Override
	public Optional<Usuario> encontrarUser(int Codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> encontrarUser(String Email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> buscarUser(String Apellido) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> listaPorCondicion(int _condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
