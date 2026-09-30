package webseite.com.app.service;

import java.util.List;
import java.util.Optional;

import webseite.com.app.model.Clientes;

public interface ClientesService {
	public Clientes save(Clientes clientes); //Recibe la Entidad "Clientes"
	public Optional<Clientes> get (Integer id);
	public void update(Clientes clientes);
	public void delete(Integer id);
	List<Clientes>listar();
	Optional<Clientes>encontrarCliente(int Codigo);
	Optional<Clientes>encontrarClientes(String Email);
	Optional<Clientes>buscarClientes(String Apellido);
	Optional<Clientes>listarPorCondicion(int _condicion);
}
