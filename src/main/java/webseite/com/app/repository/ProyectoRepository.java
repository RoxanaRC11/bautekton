package webseite.com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webseite.com.app.model.Proyecto;

@Repository 
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{

}
