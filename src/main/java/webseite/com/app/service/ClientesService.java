package webseite.com.app.service;

import java.util.Optional;

import webseite.com.app.model.Clientes;

public interface ClientesService {
	public Clientes save(Clientes clientes); //Recibe la Entidad "Clientes"
	public Optional<Clientes> get (Integer id);
	public void update(Clientes clientes);
	public void delete(Integer id);
}
