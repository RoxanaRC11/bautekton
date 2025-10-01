package webseite.com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webseite.com.app.model.Clientes;
import webseite.com.app.repository.ClienteRepository;

@Service
public class ClientesImpl implements ClientesService {
	//1. Se inyecta el Repositorio
	//Spring inyectara automaticamente la implementacion creada de JpaRepository aqui
	@Autowired
	private ClienteRepository clienteRepository;
	
	//2. Corregido el Metodo Save
	@Override
	public Clientes save(Clientes clientes) { //La logica de guardar se delega al Repositorio de JPA
		return clienteRepository.save(clientes);
	}

	//3. Agregar Logica de Busqueda 
	@Override
	public Optional<Clientes> get(Integer id) {
		//La logica de busqueda se delega al Repositorio
		return clienteRepository.findById(id);
	}

	@Override
	public void update(Clientes clientes) {
		//Logica para update, que a menudo tambien es save() en JPA si el ID ya existe.
		clienteRepository.save(clientes);
		
	}

	@Override
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
		
	}

}
