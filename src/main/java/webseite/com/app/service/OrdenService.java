package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Orden;

public interface OrdenService {
	public Orden save(Orden orden);
	public Optional<Orden> get(Integer id);
	public void update (Orden orden);
	public void delete(Integer id);
	public Optional<Orden> listar();
}
