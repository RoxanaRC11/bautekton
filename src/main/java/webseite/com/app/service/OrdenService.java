package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import webseite.com.app.model.Orden;
import webseite.com.app.model.Proyecto;

public interface OrdenService {
	Orden save(Orden orden);
	Optional<Orden> get(Integer id);
	void update (Orden orden);
	List<Orden>listar();
	public void delete(Integer id);
	Optional<Orden>encontrarOrden(int Codigo);
	Optional<Orden>encontrarOrden(Proyecto id_Proyecto);
	Optional<Orden>buscarOrden(String tipoOrden);
	Optional<Orden>listarPorCondicion(int _condicion);
	void guardar(Orden miorden);
	void eliminar(Integer id);
	Orden buscarPorId(Integer id);
	
	
}
