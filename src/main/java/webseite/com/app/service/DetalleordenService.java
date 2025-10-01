package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Detalleorden;

public interface DetalleordenService {
	public Detalleorden save(Detalleorden detalleorden);
	public Optional<Detalleorden> get(Integer id);
	public void update(Detalleorden detalleorden);
	public void delete(Integer id);
	public Optional<Detalleorden> listar();
	
	

}
