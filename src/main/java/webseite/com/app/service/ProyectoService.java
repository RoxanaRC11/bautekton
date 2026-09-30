package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import webseite.com.app.model.Proyecto;

public interface ProyectoService {
	public Proyecto save(Proyecto proyecto);
	public Optional <Proyecto>get (Integer id);
	public void update (Proyecto proyecto);
	public void delete(Integer id);
	public List<Proyecto>listar();
	public Optional<Proyecto>encontrarxNombre(String Nombre);
	public Optional<Proyecto>encontrarTipo(String Tipo);
	public Optional<Proyecto>encontrarxCliente(String cliente);
}
