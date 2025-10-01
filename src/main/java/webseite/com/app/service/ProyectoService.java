package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Proyecto;

public interface ProyectoService {
	public Proyecto save(Proyecto proyecto);
	public Optional <Proyecto>get (Integer id);
	public void update (Proyecto proyecto);
	public void delete(Integer id);
	public Optional<Proyecto>listar();
}
