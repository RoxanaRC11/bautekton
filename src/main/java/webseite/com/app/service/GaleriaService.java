package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import webseite.com.app.model.Galeria;

public interface GaleriaService {
	//recibe un objeto de tipo Galeria (la entidad)
	public Galeria save(Galeria galeria);
	
	public Optional <Galeria> get (Integer Id);
	
	public void update(Galeria galeria);
	
	public void delete(Integer id);
	
	public List<Galeria>listar();
}
