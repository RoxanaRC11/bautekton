package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Galeria;

public interface GaleriaService {
	public Galeria save(GaleriaService GaleriaService);
	public Optional <Galeria> get (Integer Id);
	public void update(Galeria galeria);
	public void delete(Integer id);
	
}
