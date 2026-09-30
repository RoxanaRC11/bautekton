package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webseite.com.app.model.Orden;
import webseite.com.app.model.Proyecto;
import webseite.com.app.repository.OrdenRepository;

@Service 
public class OrdenImpl implements OrdenService {
	
	@Autowired
	private OrdenRepository ordenRepository;

	@Override
	@Transactional //Sin readOnly: Permite Insert/Update
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	@Transactional (readOnly = true) 
	public Optional<Orden> get(Integer id) {
		return ordenRepository.findById(id);
	}

	@Override
	@Transactional 
	public void update(Orden orden) {
		ordenRepository.save(orden);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ordenRepository.deleteById(id);
	}

	@Override
	@Transactional (readOnly = true) //Recupera todos los registros de la tabla orden
	public List <Orden>listar() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	@Override
	public Optional<Orden> encontrarOrden(int Codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Orden> encontrarOrden(Proyecto id_Proyecto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Orden> buscarOrden(String tipoOrden) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Orden> listarPorCondicion(int _condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void guardar(Orden miorden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orden buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
