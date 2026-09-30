package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webseite.com.app.model.Proyecto;
import webseite.com.app.repository.ProyectoRepository;

//Implementacion de la interfaz ProyectoService para la gestion de proyecto

@Service
public class ProyectoImpl implements ProyectoService {
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	@Transactional  //Sin readOnly: Permite Insertar/Update
	public Proyecto save(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	@Transactional(readOnly = true) //Optimiza la lectura de un proyecto por ID
	public Optional<Proyecto>get(Integer Id) {
		return proyectoRepository.findById(Id);
	}

	@Override
	@Transactional  
	public void update(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		proyectoRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto>listar() {
		return proyectoRepository.findAll();
	}

	@Override
	public Optional<Proyecto> encontrarxNombre(String Nombre) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Proyecto> encontrarTipo(String Tipo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Proyecto> encontrarxCliente(String cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
