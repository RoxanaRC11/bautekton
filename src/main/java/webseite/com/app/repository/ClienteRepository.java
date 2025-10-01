package webseite.com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webseite.com.app.model.Clientes;
/** Repositorio de Spring Data JPA para la entidad Clientes.
 * JpaRepository proporciona todos los métodos CRUD básicos
 * para interactuar con la base de datos (guardar, buscar, eliminar, etc.).
 * Spring crea automáticamente una implementación de esta interfaz en tiempo de ejecución.
 * * La interfaz extiende JpaRepository<T, ID>, donde:
 * T = El tipo de la entidad (Clientes)
 * ID= El tipo de la vclave primaria(Integer) */

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer>{
	//Buscar un cliente por su correo electronico
	Optional<Clientes>findByEmail(String email);
	
	//Buscar la cantidad de clientes por un nombre especifico
	long countByNombres(String nombres);
	
	/*Busca clientes por nombre y apellido, ignorando mayusculas y minusculas*/
	Optional<Clientes>findByNombresAndApellidosIgnoreCase(String nombres, String apellidos);
	
	//Verificar si una entidad con un ID existe
	boolean existsById(Integer Id);
	
	//Buscar por nombre y apellido con paginacion
	//Page<Clientes>findByNombresAndApellidos(String nombres, String apellidos, Pageable pageable);
	
	//Buscar por nombre con ordenamiento
	List<Clientes>findByNombres(String nombres);

}
