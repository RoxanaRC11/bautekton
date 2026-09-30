package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webseite.com.app.model.Galeria;
import webseite.com.app.repository.GaleriaRepository;

@Service
public class GaleriaImpl implements GaleriaService {
	
	@Autowired //Descomentado para que Spring se conecte a la BD
	private GaleriaRepository galeriaRepository;

	@Override
	public Galeria save(Galeria galeria) {
		return galeriaRepository.save(galeria); // Guarda y devuelve el registro
	}

	@Override
	public Optional<Galeria> get(Integer Id) {
		return galeriaRepository.findById(Id); // buscar por ID
	}

	@Override
	public void update(Galeria galeria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer Id) {
		galeriaRepository.deleteById(Id);
		
	}


	@Override
	public List<Galeria> listar() { 
		return galeriaRepository.findAll(); //Tare toda la lista
	}

}
