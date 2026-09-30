package webseite.com.app.repository;

import java.util.Optional; //Importante importar Optional
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webseite.com.app.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//Al llamarse "findByEmail", JPA generara automaticamente un: 
	//SELECT * from usuario WHERE email = ?" detras de escene de forma 100% segura.
	Optional<Usuario> findByEmail(String email);


	}
