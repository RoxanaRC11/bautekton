package webseite.com.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import webseite.com.app.model.Orden;

@Service 
public class OrdenImpl implements OrdenService {

	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Orden> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Orden orden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Orden> listar() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
